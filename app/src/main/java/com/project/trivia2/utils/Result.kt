package com.project.trivia2.utils

fun playerWon(playerChoice: Int, androidChoice: Int): Boolean {
    if(playerChoice == 1 && androidChoice == 2){
        return false
    } else if(playerChoice == 1 && androidChoice == 3){
        return true
    } else if(playerChoice == 2 && androidChoice == 1){
        return true
    } else if(playerChoice == 2 && androidChoice == 3){
        return false
    } else return !(playerChoice == 3 && androidChoice == 1)
}