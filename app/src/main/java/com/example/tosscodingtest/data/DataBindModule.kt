package com.example.tosscodingtest.data

import com.example.tosscodingtest.data.repository.MenuDetailRepository
import com.example.tosscodingtest.data.repository.MenuDetailRepositoryImpl
import com.example.tosscodingtest.data.repository.MenuListRepository
import com.example.tosscodingtest.data.repository.MenuListRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class DataBindModule {

    @Binds
    abstract fun bindMenuListRepository(menuListRepositoryImpl: MenuListRepositoryImpl): MenuListRepository

    @Binds
    abstract fun bindMenuDetailRepository(menuDetailRepositoryImpl: MenuDetailRepositoryImpl): MenuDetailRepository
}