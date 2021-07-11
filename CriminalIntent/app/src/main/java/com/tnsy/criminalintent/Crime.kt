package com.tnsy.criminalintent

import java.util.*

data class Crime(
    val id: UUID = UUID.randomUUID(), // 고유 아이디 생성
    var title: String = "",
    var date: Date = Date(), //현재 일자로 초기화
    var isSolved: Boolean = false
)