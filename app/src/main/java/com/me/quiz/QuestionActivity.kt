package com.me.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.viewModels
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.me.quiz.R
import com.me.quiz.data.DataSource.questions
import com.me.quiz.databinding.ActivityQuestionBinding
import com.me.quiz.data.DataSource
import com.me.quiz.data.MAX_NO_OF_QUESTIONS
import com.me.quiz.model.QuizViewModel
import kotlin.properties.Delegates

class QuestionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuestionBinding
    private val viewModel: QuizViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // atualiza a UI com respectiva questão e respostas
        viewModel.currentQuestion.observe(this) { currentQuestion ->
            binding.apply {
                tvQuestion.text = currentQuestion.description

                op0.text = currentQuestion.answers[0]
                op1.text = currentQuestion.answers[1]
                op2.text = currentQuestion.answers[2]
                op3.text = currentQuestion.answers[3]
            }
        }

        binding.btnNext.setOnClickListener { onNext() }

    }


    private fun onNext(){

        if(binding.radioGroup.checkedRadioButtonId != -1){
            // recupera a resposta selecionada pelo usuário
            val checkedRadioButton = findViewById<RadioButton>(binding.radioGroup.checkedRadioButtonId)
            val answer = checkedRadioButton.text.toString()

            viewModel.isCorrectAnswer(answer) // verifica se a resposta está certa

            /*
            * verifica se ainda há questões para serem exibidas.
            * Se não tiver, inicia a tela de resultados
            */
            if (!viewModel.nextQuestion()){
                val intent = Intent(this@QuestionActivity, ResultActivity::class.java)
                intent.putExtra("score", viewModel.score)
                startActivity(intent)
            }

            binding.radioGroup.clearCheck()
        }else{
            MaterialAlertDialogBuilder(this@QuestionActivity)
                .setTitle(getString(R.string.ops))
                .setMessage(getString(R.string.select_answer))
                .setCancelable(true)
                .show()
        }

    }




}