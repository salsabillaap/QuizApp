package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_hasil.*

class HasilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil)

        val username = intent.getStringExtra(Constants.USER_NAME)
        tv_name.text = username
        val  totalSoal = intent.getIntExtra(Constants.TOTAL_SOAL, 0)
        val correctAnswer = intent.getIntExtra(Constants.CORRECT_ANSWER, 0)

        tv_score.text = "Skor kamu adalah $correctAnswer dari $totalSoal"

        btn_finish.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}