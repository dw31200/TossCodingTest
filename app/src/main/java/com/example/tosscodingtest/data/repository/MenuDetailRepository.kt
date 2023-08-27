package com.example.tosscodingtest.data.repository

import com.example.tosscodingtest.data.model.MenuDetail
import kotlinx.coroutines.flow.Flow

interface MenuDetailRepository {

    fun getItem(id: Int): Flow<MenuDetail?>

    suspend fun setItem(menuDetail: MenuDetail)
}