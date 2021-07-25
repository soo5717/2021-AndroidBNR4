package com.tnsy.criminalintent

import android.app.Application

class CriminalIntentApplication : Application() {
    override fun onCreate() { // 1번만 초기화 됨.
        super.onCreate()
        CrimeRepository.initialize(this)
    }
}