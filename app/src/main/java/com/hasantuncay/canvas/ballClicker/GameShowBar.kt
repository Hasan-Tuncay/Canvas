package com.hasantuncay.canvas.ballClicker

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun GameShowBar(points:Int,gameState: Boolean,onGameState : ( )-> Unit){
    var isTimerRunning by remember { mutableStateOf(false)
    }
    var time by remember {
        mutableStateOf(0)
    }
    Row (Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically){
        Text(text ="Points: $points" )
        Text(text = " Time: $time")
        Button(onClick = { onGameState()
            if (isTimerRunning == true) false else true

            countdownTimer(isTimerRunning = isTimerRunning, onCurrentTime = {time=it}) }
        ) {

            Text(text = "Start")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GameBarPreview(){
    GameShowBar(points = 3,  gameState =false ) {

    }
}