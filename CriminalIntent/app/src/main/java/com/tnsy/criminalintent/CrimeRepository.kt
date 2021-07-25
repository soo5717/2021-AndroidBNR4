package com.tnsy.criminalintent

import android.content.Context

class CrimeRepository private constructor(context: Context){ // 싱글톤
    companion object {
        private var INSTANCE: CrimeRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = CrimeRepository(context)
            }
        }

        fun get() : CrimeRepository {
            return INSTANCE ?:
            throw  IllegalStateException("CrimeRepository must be initialized")
        }
    }
}