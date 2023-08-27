package com.example.tosscodingtest.data

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.example.tosscodingtest.data.model.MenuDetail
import kotlinx.coroutines.flow.Flow

@Dao
interface MenuDetailDao {

    @Query("SELECT * FROM MenuDetail WHERE id = :id")
    fun getItem(id: Int): Flow<MenuDetail?>

    @Update
    suspend fun update(menuDetail: MenuDetail)
}