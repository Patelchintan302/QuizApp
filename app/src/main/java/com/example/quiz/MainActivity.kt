package com.example.quiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quiz.ui.QuestionActivity
import com.example.quiz.utils.Constants

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val startButton: Button = findViewById(R.id.btnStart)
        val editTextName: EditText = findViewById(R.id.name)

        startButton.setOnClickListener {
            if(!editTextName.text.toString().isEmpty()) {
                val intent = Intent(this, QuestionActivity::class.java).also{
                    it.putExtra(Constants.USER_NAME, editTextName.text.toString())
                    startActivity(it)
                    finish()
                }
            }else {
                Toast.makeText(this, "please enter your name!!",Toast.LENGTH_SHORT).show()
            }
        }


    }
}