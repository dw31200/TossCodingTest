package com.example.tosscodingtest.menucheck

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tosscodingtest.data.model.Caffeine
import com.example.tosscodingtest.data.model.IceSize
import com.example.tosscodingtest.data.model.MenuDetail
import com.example.tosscodingtest.data.model.Temp
import com.example.tosscodingtest.domain.GetMenuDetailUseCase
import com.example.tosscodingtest.domain.GetMenuItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MenuCheckViewModel @Inject constructor(
    getMenuDetailUseCase: GetMenuDetailUseCase,
    getMenuItemUseCase: GetMenuItemUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    val id = savedStateHandle.get<Int>("menuId") ?: 0
    val menuItem = getMenuItemUseCase(id)
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(),
            null,
        )
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
}
