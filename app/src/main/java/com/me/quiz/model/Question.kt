package com.me.quiz.model


class Question(
    val description: String,
    val correctAnswer: String,
    var answers: List<String>
)