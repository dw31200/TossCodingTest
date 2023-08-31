package com.example.tosscodingtest.data.repository

import com.example.tosscodingtest.data.model.MenuList
import kotlinx.coroutines.flow.Flow

interface MenuListRepository {
    fun getAll(): Flow<List<MenuList>>

    fun getItem(id: Int): Flow<MenuList>

    suspend fun setList(menuList: List<MenuList>)
}
