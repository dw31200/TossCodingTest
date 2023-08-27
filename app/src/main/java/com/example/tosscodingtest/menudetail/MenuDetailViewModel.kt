package com.example.tosscodingtest.menudetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.tosscodingtest.domain.GetMenuDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MenuDetailViewModel @Inject constructor(
    private val getMenuDetailUseCase: GetMenuDetailUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    val id = savedStateHandle.get<Int>("menuId") ?: 0
    val detail = getMenuDetailUseCase(id)
}