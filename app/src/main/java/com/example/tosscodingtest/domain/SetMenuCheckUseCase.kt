package com.example.tosscodingtest.domain

import com.example.tosscodingtest.data.model.MenuDetail
import com.example.tosscodingtest.data.repository.MenuDetailRepository
import javax.inject.Inject

class SetMenuCheckUseCase @Inject constructor(
    private val menuDetailRepository: MenuDetailRepository,
) {
    suspend operator fun invoke(menuDetail: MenuDetail) {
        menuDetailRepository.setItem(menuDetail)
    }
}