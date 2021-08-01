package com.tnsy.criminalintent.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.tnsy.criminalintent.Crime
import java.util.*

@Dao
interface CrimeDao {

    // 백그라운드 스레드에서 쿼리 실행 후 LiveData 반환
    @Query("SELECT * FROM crime")
    fun getCrimes(): LiveData<List<Crime>>

    @Query("SELECT * FROM crime WHERE id=(:id)")
    fun getCrime(id: UUID): LiveData<Crime?>
}