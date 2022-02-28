package com.me.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.me.quiz.databinding.ActivityQuestionBinding
import com.me.quiz.databinding.ActivityResultBinding
import com.me.quiz.model.QuizViewModel

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    private val viewModel: QuizViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

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

            btnTryAgain.setOnClickListener { onTryAgain() }
        }
    }

    private fun onTryAgain(){
        val intent = Intent(this@ResultActivity, MainActivity::class.java)
        startActivity(intent)
    }
}