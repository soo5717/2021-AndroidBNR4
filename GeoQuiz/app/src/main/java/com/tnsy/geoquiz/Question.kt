package com.tnsy.geoquiz

import androidx.annotation.StringRes

data class Question (@StringRes val textResId: Int, val answer: Boolean, var isCheater: Boolean = false)