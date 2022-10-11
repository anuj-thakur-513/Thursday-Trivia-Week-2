package com.project.trivia2.utils

fun choiceMade(choice: Int): String{
    return when(choice){
        1 -> "Rock"
        2 -> "Paper"
        3 -> "Scissors"
        else -> "NULL"
    }
}