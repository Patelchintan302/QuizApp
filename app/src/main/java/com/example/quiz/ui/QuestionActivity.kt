package com.example.quiz.ui

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quiz.R
import com.example.quiz.model.Questions
import com.example.quiz.utils.Constants

class QuestionActivity : AppCompatActivity() , View.OnClickListener{
    private lateinit var question : TextView
    private lateinit var progress : ProgressBar
    private lateinit var progressText : TextView
    private lateinit var option1 : TextView
    private lateinit var option2 : TextView
    private lateinit var option3 : TextView
    private lateinit var option4 : TextView
    private lateinit var checkBtn : Button
    private var currentPosition = 1
    private val questionList = Constants.getQuestions()
    private var selectedOption = 0
    private lateinit var currentQuestion : Questions
    private var answered = false
    private var score = 0
    private lateinit var userName : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_question)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val questionList = Constants.getQuestions()
        Log.d("QuestionListSize", "$questionList.size") // for logcat testing of Question List

        question = findViewById(R.id.question_text)
        progress = findViewById(R.id.progressBar)
        progressText = findViewById(R.id.progress_text)
        option1 = findViewById(R.id.option_1)
        option2 = findViewById(R.id.option_2)
        option3 = findViewById(R.id.option_3)
        option4 = findViewById(R.id.option_4)
        checkBtn = findViewById(R.id.checkBtn)

        option1.setOnClickListener(this)
        option2.setOnClickListener(this)
        option3.setOnClickListener(this)
        option4.setOnClickListener(this)
        checkBtn.setOnClickListener(this)
        showQuestion()

        if(intent.hasExtra(Constants.USER_NAME)){
            userName = intent.getStringExtra(Constants.USER_NAME).toString()
        }
    }

    fun showQuestion() {


        if(currentPosition <= questionList.size){
            resetOptions()
            currentQuestion = questionList[currentPosition - 1]
            this.question.text = currentQuestion.question
            option1.text = currentQuestion.option1
            option2.text = currentQuestion.option2
            option3.text = currentQuestion.option3
            option4.text = currentQuestion.option4
            progress.progress = currentPosition
            progressText.text = "$currentPosition/${questionList.size}"
            checkBtn.text = "CHECK"
        }else{
            checkBtn.text = "FINISH"
            Intent(this, ResultActivity::class.java).also {
                it.putExtra(Constants.USER_NAME, userName)
                it.putExtra(Constants.SCORE, score)
                it.putExtra(Constants.TOTAL_QUESTIONS, questionList.size)
                startActivity(it)
                finish()
            }
        }

        currentPosition++
        answered = false


    }

    fun resetOptions() {
        val options = mutableListOf<TextView>()
        options.add(0, option1)
        options.add(1, option2)
        options.add(2, option3)
        options.add(3, option4)
        for (option in options) {
            option.setTextColor(ContextCompat.getColor(this, R.color.gray))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.option_border_bg)
        }
    }

    private fun selectedOptionView(textview: TextView, selectedOptionNum: Int) {
        selectedOption = selectedOptionNum
        resetOptions()
        textview.setTextColor(Color.parseColor("#000000"))
        textview.setTypeface(textview.typeface, Typeface.BOLD)
        textview.background = ContextCompat.getDrawable(this,R.drawable.selected_option_border_bg)


    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.option_1 -> {
                selectedOptionView(option1, 1)
            }
            R.id.option_2 -> {
                selectedOptionView(option2, 2)
            }
            R.id.option_3 -> {
                selectedOptionView(option3, 3)
            }
            R.id.option_4 -> {
                selectedOptionView(option4, 4)
            }
            R.id.checkBtn -> {
                if(!answered){
                    checkAnswer()
                } else {
                    showQuestion()
                }
            }
        }
    }

    private fun checkAnswer() {
        answered = true
        showCorrectAnswer()
        if(selectedOption != currentQuestion.correctAnswer) {
            when (selectedOption) {
                1 -> option1.background = ContextCompat.getDrawable(this,R.drawable.wrong_option_border_bg)
                2 -> option2.background = ContextCompat.getDrawable(this,R.drawable.wrong_option_border_bg)
                3 -> option3.background = ContextCompat.getDrawable(this,R.drawable.wrong_option_border_bg)
                4 -> option4.background = ContextCompat.getDrawable(this,R.drawable.wrong_option_border_bg)
            }
        } else {
            score++
        }
        selectedOption = 0
        if(currentPosition == questionList.size) {
            checkBtn.text = "FINISH"
        }else {
            checkBtn.text = "NEXT"
        }
    }

    private fun showCorrectAnswer() {
        when (currentQuestion.correctAnswer) {
            1 -> option1.background = ContextCompat.getDrawable(this,R.drawable.correct_option_border_bg)
            2 -> option2.background = ContextCompat.getDrawable(this,R.drawable.correct_option_border_bg)
            3 -> option3.background = ContextCompat.getDrawable(this,R.drawable.correct_option_border_bg)
            4 -> option4.background = ContextCompat.getDrawable(this,R.drawable.correct_option_border_bg)
        }
    }

}
