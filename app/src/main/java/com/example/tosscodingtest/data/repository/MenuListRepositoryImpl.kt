package com.example.tosscodingtest.data.repository

import com.example.tosscodingtest.data.MenuListDao
import com.example.tosscodingtest.data.model.MenuList
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MenuListRepositoryImpl @Inject constructor(
    private val menuListDao: MenuListDao,
) : MenuListRepository {
    override fun getAll(): Flow<List<MenuList>> {
        return menuListDao.getAll()
    }

    override fun getItem(id: Int): Flow<MenuList> {
        return menuListDao.getItem(id)
    }

    override suspend fun setList(menuList: List<MenuList>) {
        menuListDao.setList(menuList)
    }
}
