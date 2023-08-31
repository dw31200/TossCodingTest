package com.example.tosscodingtest.menudetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tosscodingtest.data.model.Caffeine
import com.example.tosscodingtest.data.model.IceSize
import com.example.tosscodingtest.data.model.MenuDetail
import com.example.tosscodingtest.data.model.Temp
import com.example.tosscodingtest.domain.GetMenuDetailUseCase
import com.example.tosscodingtest.domain.GetMenuItemUseCase
import com.example.tosscodingtest.domain.SetMenuCheckUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MenuDetailViewModel @Inject constructor(
    private val getMenuDetailUseCase: GetMenuDetailUseCase,
    private val getMenuItemUseCase: GetMenuItemUseCase,
    private val setMenuCheckUseCase: SetMenuCheckUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    val id = savedStateHandle.get<Int>("menuId") ?: 0
    val detail = getMenuDetailUseCase(id)
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(),
            MenuDetail(
                id,
                Temp.HOT,
                Caffeine.CAFFEINE,
                IceSize.SMALL,
            ),
        )
    private val _temp = MutableLiveData<Temp>(Temp.HOT)
    val temp: LiveData<Temp>
        get() = _temp
    private val _caffeine = MutableLiveData<Caffeine>(Caffeine.CAFFEINE)
    val caffeine: LiveData<Caffeine>
        get() = _caffeine
    private val _iceSize = MutableLiveData<IceSize>(IceSize.SMALL)
    val iceSize: LiveData<IceSize>
        get() = _iceSize

    val menuItem = getMenuItemUseCase(id)
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(),
            null,
        )

    fun checkTemp(temp: Temp) {
        _temp.value = temp
    }

    fun checkCaffeine(caffeine: Caffeine) {
        _caffeine.value = caffeine
    }

    fun checkIceSize(iceSize: IceSize) {
        _iceSize.value = iceSize
    }

    suspend fun setMenuItem() {
        setMenuCheckUseCase(
            MenuDetail(
                id,
                temp.value ?: Temp.HOT,
                caffeine.value ?: Caffeine.CAFFEINE,
                iceSize.value ?: IceSize.SMALL,
            ),
        )
    }
}
