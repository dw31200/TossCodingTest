package com.example.tosscodingtest

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TossTestApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}