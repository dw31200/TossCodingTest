package com.example.tosscodingtest.menucheck

import androidx.lifecycle.ViewModel
import com.example.tosscodingtest.domain.GetMenuDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MenuCheckViewModel @Inject constructor(
    private val getMenuDetailUseCase: GetMenuDetailUseCase,
) : ViewModel()