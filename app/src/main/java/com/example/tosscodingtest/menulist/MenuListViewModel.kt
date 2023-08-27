package com.example.tosscodingtest.menulist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tosscodingtest.data.model.MenuList
import com.example.tosscodingtest.domain.GetMenuListUseCase
import com.example.tosscodingtest.domain.SetMenuListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuListViewModel @Inject constructor(
    private val getMenuListUseCase: GetMenuListUseCase,
    private val setMenuListUseCase: SetMenuListUseCase,
) : ViewModel() {

    init {
        val menuList = listOf(
            MenuList(
                1,
                "아메리카노",
                1000,
                "coffee",
                true,
                false,
                true,
            ),
            MenuList(
                2,
                "카페라떼",
                1500,
                "coffee",
                true,
                false,
                true,
            ),
            MenuList(
                3,
                "카푸치노",
                2000,
                "coffee",
                true,
                false,
                true,
            ),
            MenuList(
                4,
                "오렌지에이드",
                2500,
                "beverage",
                false,
                true,
                false,
            ),
            MenuList(
                5,
                "망고에이드",
                2500,
                "beverage",
                false,
                true,
                false,
            ),
            MenuList(
                6,
                "얼그레이티",
                1000,
                "tea",
                false,
                false,
                true,
            ),
            MenuList(
                7,
                "페퍼민트티",
                1000,
                "tea",
                false,
                false,
                true,
            ),
            MenuList(
                8,
                "치즈케이크",
                3000,
                "desert",
                false,
                false,
                false,
            ),
            MenuList(
                9,
                "초코케이크",
                3000,
                "desert",
                false,
                false,
                false,
            ),
            MenuList(
                10,
                "마들렌",
                1000,
                "desert",
                false,
                false,
                false,
            ),
            MenuList(
                11,
                "휘낭시에",
                1500,
                "desert",
                false,
                false,
                false,
            ),
        )
        viewModelScope.launch {
            setMenuListUseCase(menuList)
        }
    }

    val list = getMenuListUseCase()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(),
            null,
        )
}
