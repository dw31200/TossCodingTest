package com.example.tosscodingtest.domain

import com.example.tosscodingtest.data.model.MenuDetail
import com.example.tosscodingtest.data.repository.MenuDetailRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMenuDetailUseCase @Inject constructor(
    private val menuDetailRepository: MenuDetailRepository,
) {
    operator fun invoke(id: Int): Flow<MenuDetail?> {
        return menuDetailRepository.getItem(id)
    }
}