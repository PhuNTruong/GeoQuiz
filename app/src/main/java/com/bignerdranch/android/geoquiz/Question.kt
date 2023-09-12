package com.bignerdranch.android.geoquiz
//2.1
import androidx.annotation.StringRes

data class Question(@StringRes val textResId: Int, val answer: Boolean)