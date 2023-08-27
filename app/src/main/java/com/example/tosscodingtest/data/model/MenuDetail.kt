package com.example.tosscodingtest.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MenuDetail(
    @PrimaryKey
    val id: Int,
    val temp: Temp,
    val caffeine: Caffeine,
    val iceSize: IceSize,
)

enum class Temp {
    HOT, ICE
}

enum class Caffeine {
    CAFFEINE, DECAFFEINE
}

enum class IceSize {
    SMALL, MEDIUM, LARGE
}
