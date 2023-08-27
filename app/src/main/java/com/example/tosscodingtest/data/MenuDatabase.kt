package com.example.tosscodingtest.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tosscodingtest.data.model.MenuDetail
import com.example.tosscodingtest.data.model.MenuList

@Database(entities = [MenuList::class, MenuDetail::class], version = 1)
abstract class MenuDatabase : RoomDatabase() {
    abstract fun menuListDao(): MenuListDao

    abstract fun menuDetailDao(): MenuDetailDao
}