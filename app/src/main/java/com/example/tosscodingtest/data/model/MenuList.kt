package com.example.tosscodingtest.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MenuList(
    @PrimaryKey
    val id: Int,
    val name: String,
    val price: Int,
    val type: Int,
    val isTempCheckable: Boolean,
    val isOnlyIce: Boolean,
    val isCaffeineCheckable: Boolean,
)
