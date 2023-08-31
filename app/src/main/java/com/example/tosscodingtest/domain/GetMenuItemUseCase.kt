package com.example.tosscodingtest.domain

import com.example.tosscodingtest.data.model.MenuList
import com.example.tosscodingtest.data.repository.MenuListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMenuItemUseCase @Inject constructor(
    private val menuListRepository: MenuListRepository,
) {
    operator fun invoke(id: Int): Flow<MenuList> {
        return menuListRepository.getItem(id)
    }
}
