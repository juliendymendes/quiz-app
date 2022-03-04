package com.me.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.me.quiz.databinding.ActivityQuestionBinding
import com.me.quiz.databinding.ActivityResultBinding
import com.me.quiz.model.QuizViewModel
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        val startTime = intent.extras?.getString("startTime")?.toLong()

        val endTime = Date().time

        // tempo de que levou para terminar o quiz em segundos
        val finalTime = (endTime - startTime!!)/1000

        val score = intent.extras?.getInt("score")

        binding.apply {
            if(score!! >= 6){
                ivImage.setImageResource(R.drawable.victory)
                tvMessage.text = getString(R.string.congrats)
            }else{
                ivImage.setImageResource(R.drawable.fail)
                tvMessage.text = getString(R.string.fail)

            }
            tvHits.text = getString(R.string.hits, score)
            tvTime.text = getString(R.string.time, finalTime)
            btnTryAgain.setOnClickListener { onTryAgain() }

        }
    }

    private fun onTryAgain(){
        val intent = Intent(this@ResultActivity, MainActivity::class.java)
        startActivity(intent)
    }
}