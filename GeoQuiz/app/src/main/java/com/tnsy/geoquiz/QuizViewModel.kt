package com.tnsy.geoquiz

import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"

class QuizViewModel : ViewModel() {

    var currentIndex = 0

    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer

    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId

    // 챌린지2 : 문제마다 커닝 여부 관리하기
    val currentQuestionCheater: Boolean
        get() = questionBank[currentIndex].isCheater

    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }

    // 챌린지2 : 문제마다 커닝 여부 관리하기
    fun setCheater(isCheater: Boolean) {
        questionBank[currentIndex].isCheater = isCheater
    }
}