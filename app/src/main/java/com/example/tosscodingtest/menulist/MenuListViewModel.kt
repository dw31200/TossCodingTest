package com.example.tosscodingtest.menulist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tosscodingtest.data.model.MenuList
import com.example.tosscodingtest.domain.GetMenuListUseCase
import com.example.tosscodingtest.domain.SetMenuListUseCase
import com.example.tosscodingtest.menulist.adapter.MENU
import com.example.tosscodingtest.menulist.adapter.MENU_BLANK
import com.example.tosscodingtest.menulist.adapter.MENU_HEADER
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuListViewModel @Inject constructor(
    getMenuListUseCase: GetMenuListUseCase,
    private val setMenuListUseCase: SetMenuListUseCase,
) : ViewModel() {

    init {
        val menuList = listOf(
            MenuList(
                0,
                "COFFEE",
                0,
                MENU_HEADER,
                true,
                true,
                true,
            ),
            MenuList(
                1,
                "아메리카노",
                1000,
                MENU,
                true,
                false,
                true,
            ),
            MenuList(
                2,
                "카페라떼",
                1500,
                MENU,
                true,
                false,
                true,
            ),
            MenuList(
                3,
                "카푸치노",
                2000,
                MENU,
                true,
                false,
                true,
            ),
            MenuList(
                4,
                "",
                0,
                MENU_BLANK,
                true,
                true,
                true,
            ),
            MenuList(
                5,
                "BEVERAGE",
                0,
                MENU_HEADER,
                true,
                true,
                true,
            ),
            MenuList(
                6,
                "오렌지에이드",
                2500,
                MENU,
                true,
                true,
                false,
            ),
            MenuList(
                7,
                "망고에이드",
                2500,
                MENU,
                true,
                true,
                false,
            ),
            MenuList(
                8,
                "",
                0,
                MENU_BLANK,
                true,
                true,
                true,
            ),
            MenuList(
                9,
                "TEA",
                0,
                MENU_HEADER,
                true,
                true,
                true,
            ),
            MenuList(
                10,
                "얼그레이티",
                1000,
                MENU,
                false,
                false,
                true,
            ),
            MenuList(
                11,
                "페퍼민트티",
                1000,
                MENU,
                false,
                false,
                true,
            ),
            MenuList(
                12,
                "",
                0,
                MENU_BLANK,
                true,
                true,
                true,
            ),
            MenuList(
                13,
                "DESSERT",
                0,
                MENU_HEADER,
                true,
                true,
                true,
            ),
            MenuList(
                14,
                "치즈케이크",
                3000,
                MENU,
                false,
                false,
                false,
            ),
            MenuList(
                15,
                "초코케이크",
                3000,
                MENU,
                false,
                false,
                false,
            ),
            MenuList(
                16,
                "마들렌",
                1000,
                MENU,
                false,
                false,
                false,
            ),
            MenuList(
                17,
                "휘낭시에",
                1500,
                MENU,
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
