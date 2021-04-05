package com.example.notes.util

import android.app.Application
import com.example.notes.model.MainDatabase
import com.example.notes.ui.MainRepository

class MainApplication: Application() {

    private val mainDatabase by lazy { MainDatabase.getInstance(this) }

    val mainRepository by lazy { MainRepository(mainDatabase.mainDao()) }
}