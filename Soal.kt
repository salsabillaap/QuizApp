package com.example.quizapp

data class Soal (
    val id: Int,
    val soal: String,
    val image: Int,
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFour: String,
    val correctAnswer: Int,
)