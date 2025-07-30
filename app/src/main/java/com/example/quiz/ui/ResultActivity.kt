package com.example.quiz.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quiz.MainActivity
import com.example.quiz.R
import com.example.quiz.utils.Constants

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val userNAme = findViewById<TextView>(R.id.user_name)
        val userScore = findViewById<TextView>(R.id.user_score)
        val btnFinish = findViewById<Button>(R.id.btnFinish)

        userNAme.text = intent.getStringExtra(Constants.USER_NAME)
        userScore.text = "Your Score ${intent.getIntExtra(Constants.SCORE, 0)} out of ${intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)}"


        btnFinish.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).also{
                startActivity(it)
                finish()
            }
        }

    }
}