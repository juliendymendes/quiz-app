package com.me.quiz.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.me.quiz.data.DataSource
import com.me.quiz.data.MAX_NO_OF_QUESTIONS

class QuizViewModel: ViewModel() {
    private val questions = DataSource.questions

    private var _currentQuestion = MutableLiveData<Question>()
    val currentQuestion: LiveData<Question> = _currentQuestion

    private  var questionCount = 0

    var score = 0

    //TODO variável de tempo

    private var questionsList = mutableListOf<Question>()
    private lateinit var tempQuestion: Question

    /*
     *atualiza a _currentQuestion com uma questao aleatoria e com as respostas embaralhadas
     */
    private fun getNextQuestion(){
        tempQuestion = questions.random()
        tempQuestion.answers = tempQuestion.answers.shuffled()
        if(questionsList.contains(tempQuestion)){
            getNextQuestion()
        }else{
            _currentQuestion.value = tempQuestion
            questionCount += 1
            questionsList.add(tempQuestion)

        }


    }

    fun nextQuestion(): Boolean{
        return if(questionCount < MAX_NO_OF_QUESTIONS){
            getNextQuestion()
            true
        }else false
    }


    fun isCorrectAnswer(answer: String){
        if(answer == currentQuestion.value!!.correctAnswer) {
            this.score +=1
        }

    }

    init {
        getNextQuestion()
    }


}