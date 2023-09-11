package com.bignerdranch.android.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import com.bignerdranch.android.geoquiz.databinding.ActivityMainBinding

private const val TAG = "MainActivity" // 3.1

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding // 2.7

    private val quizViewModel: QuizViewModel by viewModels() // 4.3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate(Bundle?) called") // 3.2
        binding = ActivityMainBinding.inflate(layoutInflater) // 2.7
        setContentView(binding.root) // 2.7

        Log.d(TAG, "Got a QuizViewModel: $quizViewModel") //4.3


        binding.trueButton.setOnClickListener { view: View ->
            checkAnswer(true)
        }

        binding.falseButton.setOnClickListener { view: View ->
            checkAnswer(false)
        }

        binding.nextButton.setOnClickListener {
            quizViewModel.moveToNext() //4.7
            updateQuestion()

        }

        updateQuestion()
    }

    //Overriding lifecycle callback functions
    //Calling the superclass implementation should be the first line of each callback function override implementation.
    override fun onStart() { // 3.3
        super.onStart()
        Log.d(TAG, "onStart() called")
    }

    override fun onResume() { //3.3
        super.onResume()
        Log.d(TAG, "onResume() called")
    }

    override fun onPause() { //3.3
        super.onPause()
        Log.d(TAG, "onPause() called")
    }

    override fun onStop() { //3.3
        super.onStop()
        Log.d(TAG, "onStop() called")
    }

    override fun onDestroy() { //3.3
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }



    private fun updateQuestion() {
        val questionTextResId = quizViewModel.currentQuestionText //4
        binding.questionTextView.setText(questionTextResId)
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = quizViewModel.currentQuestionAnswer //4

        val messageResId = if (userAnswer == correctAnswer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
            .show()

    }

}
