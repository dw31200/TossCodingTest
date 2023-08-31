package com.example.tosscodingtest.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.tosscodingtest.data.model.MenuDetail
import com.example.tosscodingtest.data.model.MenuList

@Database(entities = [MenuList::class, MenuDetail::class], version = 2)
abstract class MenuDatabase : RoomDatabase() {
    abstract fun menuListDao(): MenuListDao

    abstract fun menuDetailDao(): MenuDetailDao
}

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "ALTER TABLE MenuList ALTER COLUMN type INTEGER",
        )
    }
}
