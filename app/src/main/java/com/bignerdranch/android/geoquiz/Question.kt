package com.bignerdranch.android.geoquiz

import androidx.annotation.StringRes

data class Question(@StringRes val textResId: Int, val answer: Boolean, var answered: Boolean = false)
//for challenge:preventing repeat answers: I added another value to the question class to decide if a question was answered or not
//the question is always not answered at the start