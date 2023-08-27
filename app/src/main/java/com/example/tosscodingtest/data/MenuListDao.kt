package com.example.tosscodingtest.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tosscodingtest.data.model.MenuList
import kotlinx.coroutines.flow.Flow

@Dao
interface MenuListDao {

    @Query("SELECT * FROM menuList ORDER BY ID ASC")
    fun getAll(): Flow<List<MenuList>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setList(menuList: List<MenuList>)
}