package com.tnsy.criminalintent

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity // 테이블 구조
data class Crime(
    @PrimaryKey val id: UUID = UUID.randomUUID(), // 고유 아이디 생성
    var title: String = "",
    var date: Date = Date(), //현재 일자로 초기화
    var isSolved: Boolean = false
)