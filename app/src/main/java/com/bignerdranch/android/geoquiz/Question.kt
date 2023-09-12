package com.bignerdranch.android.geoquiz
//2.1
import androidx.annotation.StringRes

//Added an answered attribute to see if question has been answered
data class Question(@StringRes val textResId: Int, val answer: Boolean, var answered: Boolean = false)