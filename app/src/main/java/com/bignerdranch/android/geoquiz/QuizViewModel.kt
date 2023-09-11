package com.bignerdranch.android.geoquiz

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

//Listing 4.2:Creating a ViewModel Class
//private const val TAG = "QuizViewModel" //you remove this in 5.5
const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY" //4.8 Storing data in SavedStateHandle

class QuizViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {// 4.8

    //4.5:Pasting model data into QuizViewModel
    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true))

    private var currentIndex: Int
        get() = savedStateHandle.get(CURRENT_INDEX_KEY) ?: 0
        set(value) = savedStateHandle.set(CURRENT_INDEX_KEY, value)

    //Listing 4.6: Adding business logic to QuizViewModel
    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer

    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId

    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }

}