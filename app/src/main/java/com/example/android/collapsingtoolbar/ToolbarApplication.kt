package com.example.android.collapsingtoolbar

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen

class ToolbarApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
    }
}