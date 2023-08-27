package com.example.tosscodingtest.data

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Singleton
    @Provides
    fun provideMenuDatabase(
        @ApplicationContext context: Context,
    ): MenuDatabase {
        return Room.databaseBuilder(
            context,
            MenuDatabase::class.java,
            "menu.db",
        )
            .build()
    }

    @Singleton
    @Provides
    fun provideMenuListDao(
        database: MenuDatabase,
    ): MenuListDao {
        return database.menuListDao()
    }

    @Singleton
    @Provides
    fun provideMenuDetailDao(
        database: MenuDatabase,
    ): MenuDetailDao {
        return database.menuDetailDao()
    }
}