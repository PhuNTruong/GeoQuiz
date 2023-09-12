package com.bignerdranch.android.geoquiz

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

//Listing 4.2:Creating a ViewModel Class
//private const val TAG = "QuizViewModel" //you remove this in 5.5
const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY" //4.8 Storing data in SavedStateHandle
const val IS_CHEATER_KEY = "IS_CHEATER_KEY" // 7.15
<<<<<<< Updated upstream
class QuizViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {// 4.8

    //4.5:Pasting model data into QuizViewModel
    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true))
=======
const val CURRENT_SCORE_KEY = "CURRENT_SCORE_KEY" // Challenge Graded Quiz
class QuizViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {// 4.8

    //4.5:Pasting model data into QuizViewModel
    val questionBank = listOf(
        Question(R.string.question_largest, false),
        Question(R.string.question_smallest, true),
        Question(R.string.question_poly, true),
        Question(R.string.question_rank1, true),
        Question(R.string.question_beef, false),
        Question(R.string.question_icecream, true))
>>>>>>> Stashed changes

    //7.15
    var isCheater: Boolean
        get() = savedStateHandle.get(IS_CHEATER_KEY) ?: false
        set(value) = savedStateHandle.set(IS_CHEATER_KEY, value)

<<<<<<< Updated upstream
    private var currentIndex: Int
        get() = savedStateHandle.get(CURRENT_INDEX_KEY) ?: 0
        set(value) = savedStateHandle.set(CURRENT_INDEX_KEY, value)

=======
    var currentIndex: Int
        get() = savedStateHandle.get(CURRENT_INDEX_KEY) ?: 0
        set(value) = savedStateHandle.set(CURRENT_INDEX_KEY, value)

    //Challenge: Graded Quiz
    var score: Int
        get() = savedStateHandle.get(CURRENT_SCORE_KEY) ?: 0
        set(value) = savedStateHandle.set(CURRENT_SCORE_KEY, value)

>>>>>>> Stashed changes
    //Listing 4.6: Adding business logic to QuizViewModel
    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer

    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId

    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }

<<<<<<< Updated upstream
=======
    //Challenge: Add a Previous Button
    //This allows it to go back
    fun moveToPrevious() {
        currentIndex = (currentIndex + questionBank.size - 1) % questionBank.size
    }


>>>>>>> Stashed changes
}