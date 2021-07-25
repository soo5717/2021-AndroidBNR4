package com.tnsy.criminalintent

import android.content.Context
import androidx.room.Room
import com.tnsy.criminalintent.database.CrimeDatabase
import java.util.*

private const val DATABASE_NAME = "crime-database"

class CrimeRepository private constructor(context: Context){ // 싱글톤

    // 데이터베이스 생성
    private val database : CrimeDatabase = Room.databaseBuilder(
        context.applicationContext,
        CrimeDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val crimeDao = database.crimeDao()

    fun getCrimes(): List<Crime> = crimeDao.getCrimes()

    fun getCrime(id: UUID): Crime? = crimeDao.getCrime(id)

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