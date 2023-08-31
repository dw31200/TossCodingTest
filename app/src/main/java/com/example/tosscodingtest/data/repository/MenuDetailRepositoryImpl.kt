package com.example.tosscodingtest.data.repository

import com.example.tosscodingtest.data.MenuDetailDao
import com.example.tosscodingtest.data.model.MenuDetail
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MenuDetailRepositoryImpl @Inject constructor(
    private val menuDetailDao: MenuDetailDao,
) : MenuDetailRepository {
    override fun getItem(id: Int): Flow<MenuDetail?> {
        return menuDetailDao.getItem(id)
    }

    override suspend fun setItem(menuDetail: MenuDetail) {
        menuDetailDao.insert(menuDetail)
    }
}
