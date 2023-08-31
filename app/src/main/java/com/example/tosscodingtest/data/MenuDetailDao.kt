package com.example.tosscodingtest.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.tosscodingtest.data.model.MenuDetail
import kotlinx.coroutines.flow.Flow

@Dao
interface MenuDetailDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(menuDetail: MenuDetail)

    @Query("SELECT * FROM MenuDetail WHERE id = :id")
    fun getItem(id: Int): Flow<MenuDetail?>

    @Update
    suspend fun update(menuDetail: MenuDetail)
}
