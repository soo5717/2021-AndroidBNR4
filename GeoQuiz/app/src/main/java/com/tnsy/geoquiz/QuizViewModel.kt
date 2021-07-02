package com.tnsy.geoquiz

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"

class QuizViewModel : ViewModel() {

    init {
        Log.d(TAG, "ViewModel instance created")
    }

    override fun onCleared() { // ViewModel이 소멸되기 직전에 호출 됨.
        super.onCleared()
        Log.d(TAG, "ViewModel instance about to be destroyed")
    }
}