package com.example.quiz.ui

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quiz.R
import com.example.quiz.utils.Constants

class QuestionActivity : AppCompatActivity() {
    private lateinit var question : TextView
    private lateinit var progress : ProgressBar
    private lateinit var progressText : TextView
    private lateinit var option1 : TextView
    private lateinit var option2 : TextView
    private lateinit var option3 : TextView
    private lateinit var option4 : TextView
    private lateinit var checkBtn : Button
    private val currentPosition = 1
    private val questionList = Constants.getQuestions()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
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
        setQuestion()
    }

    fun setQuestion(){
        val question = questionList[currentPosition - 1]
        this.question.text = question.question
        option1.text = question.option1
        option2.text = question.option2
        option3.text = question.option3
        option4.text = question.option4
        progress.progress = currentPosition
        progressText.text = "$currentPosition/${questionList.size}"

    }

}
