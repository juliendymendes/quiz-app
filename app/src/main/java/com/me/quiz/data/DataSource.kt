package com.me.quiz.data

import com.me.quiz.model.Question
const val MAX_NO_OF_QUESTIONS = 10
object DataSource{
    val questions = listOf(
        Question("In which part of your body would you find the cruciate ligament?","Knee", listOf("Shoulder", "Neck", "Foot", "Knee")),
        Question("What is the name of the main antagonist in the Shakespeare play Othello?","Iago", listOf("Peter", "George", "Paul", "Iago")),
        Question("What is the capital of New Zealand?","Wellington", listOf("Auckland","Dunedin", "Hamilton", "Wellington")),
        Question("What is the smallest planet in our solar system?","Mercury", listOf("Uranus", "Neptune", "Venus", "Mercury")),
        Question("How many of Henry VIII’s wives were called Catherine?", "3", listOf("5", "2", "4", "3")),
        Question("What was the most popular girls name in the UK in 2019?","Olivia", listOf("Mary", "Catherine", "Elizabeth", "Olivia")),
        Question("From which US city do the band The Killers originate?","Las Vegas", listOf("New York", "Houston", "Seattle", "Las Vegas")),
        Question("Which popular video game franchise has released games with the subtitles World At War and Black Ops?", "Call of Duty", listOf("League of Legends", "God of War", "Assassins Creed", "Call of Duty")),
        Question("In what US State is the city Nashville?","Tennessee", listOf("Texas", "New Jersey", "Utah", "Tennessee")),
        Question("How many human players are there on each side in a polo match?", "Four", listOf("Five", "Ten", "Nine", "Four"))
    )
}
