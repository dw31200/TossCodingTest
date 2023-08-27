package com.example.tosscodingtest.domain

import com.example.tosscodingtest.data.model.MenuList
import com.example.tosscodingtest.data.repository.MenuListRepository
import javax.inject.Inject

class SetMenuListUseCase @Inject constructor(
    private val menuListRepository: MenuListRepository,
) {
    suspend operator fun invoke(menuList: List<MenuList>) {
        menuListRepository.setList(menuList)
    }
}