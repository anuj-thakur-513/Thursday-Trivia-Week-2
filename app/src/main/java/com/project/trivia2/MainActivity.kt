package com.project.trivia2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.trivia2.ui.theme.Trivia2Theme
import com.project.trivia2.utils.choiceMade
import com.project.trivia2.utils.generateRandom
import com.project.trivia2.utils.playerWon

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent()
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    Trivia2Theme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            content()
        }
    }
}

@Composable
fun MainContent() {
    var playerChoice by remember {
        mutableStateOf(1)
    }
    var androidChoice by remember {
        mutableStateOf(2)
    }

    var playerScore by remember {
        mutableStateOf(0)
    }

    var androidScore by remember {
        mutableStateOf(0)
    }
    Column {
        Surface(
            modifier = Modifier.height(340.dp)
                .fillMaxWidth(),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painterResource(R.drawable.logo_rps), contentDescription = "Logo")
                Text(
                    text = "Score",
                    fontSize = 30.sp,
                    modifier = Modifier.padding(top = 8.dp),
                )
                Text(
                    text = "$playerScore / $androidScore",
                    fontSize = 50.sp,
                    modifier = Modifier.padding(top = 4.dp),
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }
        Surface(
            modifier = Modifier.fillMaxWidth()
                .height(170.dp)
        ) {
            Row(
                modifier = Modifier.padding(2.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "You Chose", fontSize = 16.sp
                    )
                    Text(
                        text = choiceMade(playerChoice), fontSize = 32.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
                Spacer(modifier = Modifier.padding(12.dp))
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Android Chose", fontSize = 16.sp
                    )
                    Text(
                        text = choiceMade(androidChoice), fontSize = 32.sp,
                        fontWeight = FontWeight.ExtraBold,
                    )
                }
            }
        }
        // buttons to choose the player option
        Surface(
            modifier = Modifier.padding(24.dp)
                .fillMaxWidth()
                .height(120.dp)
        ) {
            Row(
                modifier = Modifier.padding(2.dp).fillMaxSize(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(modifier = Modifier.weight(1f)
                    .padding(8.dp)
                    .fillMaxHeight(),
                    shape = RoundedCornerShape(corner = CornerSize(20.dp)),
                    onClick = {
                        playerChoice = 1
                        androidChoice = generateRandom()
                        if (playerChoice == androidChoice) {
                            playerScore += 0
                            androidScore += 0
                        } else if(playerWon(playerChoice, androidChoice)){
                            playerScore++
                        } else {
                            androidScore++
                        }
                    }) {
                    Text(text = "Rock")
                }
                Button(modifier = Modifier.weight(1f)
                    .padding(8.dp)
                    .fillMaxHeight(),
                    shape = RoundedCornerShape(corner = CornerSize(20.dp)),
                    onClick = {
                        playerChoice = 2
                        androidChoice = generateRandom()
                        if (playerChoice == androidChoice) {
                            playerScore += 0
                            androidScore += 0
                        } else if(playerWon(playerChoice, androidChoice)){
                            playerScore++
                        } else {
                            androidScore++
                        }
                    }) {
                    Text(text = "Paper")
                }
                Button(modifier = Modifier.weight(1f)
                    .padding(8.dp)
                    .fillMaxHeight(),
                    shape = RoundedCornerShape(corner = CornerSize(20.dp)),
                    onClick = {
                        playerChoice = 3
                        androidChoice = generateRandom()
                        if (playerChoice == androidChoice) {
                            playerScore += 0
                            androidScore += 0
                        } else if(playerWon(playerChoice, androidChoice)){
                            playerScore++
                        } else {
                            androidScore++
                        }
                    }) {
                    Text(text = "Scissors")
                }
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth()
                .fillMaxHeight()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            Text(text = "#JetpackCompose", fontFamily = FontFamily.SansSerif, fontSize = 20.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        MainContent()
    }
}