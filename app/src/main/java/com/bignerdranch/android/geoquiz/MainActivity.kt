package com.bignerdranch.android.geoquiz

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.bignerdranch.android.geoquiz.databinding.ActivityMainBinding

private const val TAG = "MainActivity" // 3.1

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding // 2.7

    private val quizViewModel: QuizViewModel by viewModels() // 4.3

    //Listing 7.12 Creating CheatLauncher
    private val cheatLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        // Handle the result
        //7.16 Pulling out the data in cheatLauncher
        if (result.resultCode == Activity.RESULT_OK) {
            quizViewModel.isCheater =
                result.data?.getBooleanExtra(EXTRA_ANSWER_SHOWN, false) ?: false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate(Bundle?) called") // 3.2
        binding = ActivityMainBinding.inflate(layoutInflater) // 2.7
        setContentView(binding.root) // 2.7

        Log.d(TAG, "Got a QuizViewModel: $quizViewModel") //4.3


        binding.trueButton.setOnClickListener { view: View ->
<<<<<<< Updated upstream
=======
            //Challenge:Prevent Repeat
            preventRepeat()
>>>>>>> Stashed changes
            checkAnswer(true)
        }

        binding.falseButton.setOnClickListener { view: View ->
<<<<<<< Updated upstream
            checkAnswer(false)
        }

        binding.nextButton.setOnClickListener {
            quizViewModel.moveToNext() //4.7
=======
            //Challenge:Prevent Repeat
            preventRepeat()
            checkAnswer(false)
        }

        //Challenge: Add Previous Button
        binding.previousButton.setOnClickListener {
            quizViewModel.moveToPrevious()
            checkIfAnswered(quizViewModel.currentIndex)
>>>>>>> Stashed changes
            updateQuestion()

        }
//Listing 7.5 Wiring up the cheat button
        binding.cheatButton.setOnClickListener {
            // Start CheatActivity
            //Listing 7.6 Starting CheatActivity
            //Listing 7.9 Launching CheatActivity with an Extra
            val answerIsTrue = quizViewModel.currentQuestionAnswer
            val intent = CheatActivity.newIntent(this@MainActivity, answerIsTrue)
            //Listing 7.13 Launching cheatLauncher
            cheatLauncher.launch(intent)
        }


<<<<<<< Updated upstream
=======
        binding.nextButton.setOnClickListener {
            quizViewModel.moveToNext() //4.7
            checkIfAnswered(quizViewModel.currentIndex)
            updateQuestion()

        }
//Listing 7.5 Wiring up the cheat button
        binding.cheatButton.setOnClickListener {
            // Start CheatActivity
            //Listing 7.6 Starting CheatActivity
            //Listing 7.9 Launching CheatActivity with an Extra
            val answerIsTrue = quizViewModel.currentQuestionAnswer
            val intent = CheatActivity.newIntent(this@MainActivity, answerIsTrue)
            //Listing 7.13 Launching cheatLauncher
            cheatLauncher.launch(intent)
        }


>>>>>>> Stashed changes
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

        //7.17 Changing toast message based on value of isCheater
        val messageResId = when {
            quizViewModel.isCheater -> R.string.judgment_toast
<<<<<<< Updated upstream
            userAnswer == correctAnswer -> R.string.correct_toast
            else -> R.string.incorrect_toast
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
            .show()

=======
            userAnswer == correctAnswer -> R.string.correct_toast;
            else -> R.string.incorrect_toast
        }

        if(userAnswer == correctAnswer){
            quizViewModel.score += 1
        }



        //for challenge graded quiz:
        var testPercentage = (quizViewModel.score * 100) / quizViewModel.questionBank.size

        //will make last toast say the score as well
        if(quizViewModel.currentIndex == quizViewModel.questionBank.size - 1){
            Toast.makeText(this, this.getString(messageResId )+ " Final Score: $testPercentage %" , Toast.LENGTH_SHORT) //need to find a way to display the score
                .show()
        }
        else{
            Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
                .show()
        }
        //


    }

    //Challenge: Prevent Repeat
    private fun checkIfAnswered(index: Int){
        val isAnswered = quizViewModel.questionBank[index].answered //this will be true or false
        //if the question is answered, == true, then the buttons are disabled
        //if the question is not answered, = =false, then the buttons are still enabled
        binding.trueButton.isEnabled = !isAnswered
        binding.falseButton.isEnabled = !isAnswered

    }

    //Challenge: Prevent Repeat
    private fun preventRepeat(){
        binding.trueButton.isEnabled = false
        binding.falseButton.isEnabled = false
        quizViewModel.questionBank[quizViewModel.currentIndex].answered = true
>>>>>>> Stashed changes
    }




}
