package com.bignerdranch.android.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.bignerdranch.android.geoquiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //2.7
    private lateinit var binding: ActivityMainBinding


    //2.5
    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true))

    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //2.7
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        //2.8
        binding.trueButton.setOnClickListener { view: View ->
            //2.13
            preventRepeat() // Challenge:  Prevent Repeat
            checkAnswer(true)
        }

        //2.8
        binding.falseButton.setOnClickListener { view: View ->
            //2.13
            preventRepeat() // Challenge:  Prevent Repeat
            checkAnswer(false)
        }

        /*Challenge: add a Previous Button
        binding.previousButton.setOnClickListener {
            currentIndex = (currentIndex + questionBank.size - 1) % questionBank.size
            updateQuestion()

        }*/

        //2.10
        binding.nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            checkIfAnswered(currentIndex)
            updateQuestion()

        }

        //2.9
        updateQuestion()
    }

    //2.11
    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        binding.questionTextView.setText(questionTextResId)
    }

    //2.12
    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = questionBank[currentIndex].answer

        val messageResId = if (userAnswer == correctAnswer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
            .show()
    }

    //Challenge: Prevent Repeat
    private fun checkIfAnswered(index: Int){
        val isAnswered = questionBank[index].answered //this will be true or false
        //if the question is answered, == true, then the buttons are disabled
        //if the question is not answered, = =false, then the buttons are still enabled
        binding.trueButton.isEnabled = !isAnswered
        binding.falseButton.isEnabled = !isAnswered

    }

    //Challenge: Prevent Repeat
    private fun preventRepeat(){
        binding.trueButton.isEnabled = false
        binding.falseButton.isEnabled = false
        questionBank[currentIndex].answered = true
    }

}
