package com.hasantuncay.canvas.ballClicker

import androidx.compose.material3.Button
import androidx.compose.material3.Text

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt
import kotlin.random.Random


@Composable
fun MainScreen() {
    var points by remember {
        mutableStateOf(0)
    }
    var isTimerRunning by remember {
        mutableStateOf(false)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Points: $points",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Button(onClick = {
                isTimerRunning = !isTimerRunning
                points = 0
            }) {
                Text(text = if(isTimerRunning) "Reset" else "Start")
            }
            CountdownTimer(
                isTimerRunning = isTimerRunning
            ) {
                isTimerRunning = false
            }
        }
//        BallClicker(
//            enabled = isTimerRunning
//        ) {
//            points++
//        }
        SquareClicker(
            enabled = isTimerRunning
        ) {
            points++
        }
    }
}

@Composable
fun CountdownTimer(
    time: Int = 30000,
    isTimerRunning: Boolean = false,
    onTimerEnd: () -> Unit = {}
) {
    var curTime by remember {
        mutableStateOf(time)
    }
    LaunchedEffect(key1 = curTime, key2 = isTimerRunning) {
        if(!isTimerRunning) {
            curTime = time
            return@LaunchedEffect
        }
        if(curTime > 0) {
            delay(1000L)
            curTime -= 1000
        } else {
            onTimerEnd()
        }
    }
    Text(
        text = (curTime / 1000).toString(),
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun BallClicker(
    radius: Float = 100f,
    enabled: Boolean = false,
    ballColor: Color = Color.Red,
    onBallClick: () -> Unit = {}
) {
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        var ballPosition by remember {
            mutableStateOf(
                randomOffset(
                    radius = radius,
                    width = constraints.maxWidth,
                    height = constraints.maxHeight
                )
            )
        }
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(enabled) {
                    if (!enabled) {
                        return@pointerInput
                    }
                    detectTapGestures {
                        val distance = sqrt(
                            (it.x - ballPosition.x).pow(2) +
                                    (it.y - ballPosition.y).pow(2)
                        )
                        if (distance <= radius) {
                            ballPosition = randomOffset(
                                radius = radius,
                                width = constraints.maxWidth,
                                height = constraints.maxHeight
                            )
                            onBallClick()
                        }
                    }
                }
        ) {
            drawCircle(
                color = ballColor,
                radius = radius,
                center = ballPosition
            )
        }
    }
}

private fun randomOffset(radius: Float, width: Int, height: Int): Offset {
    return Offset(
        x = Random.nextInt(radius.roundToInt(), width - radius.roundToInt()).toFloat(),
        y = Random.nextInt(radius.roundToInt(), height - radius.roundToInt()).toFloat()
    )
}
@Composable
fun SquareClicker(
    edge: Int = 600 ,
    enabled: Boolean = false,
    squareColor: Color = Color.Red,
    onSquareClick: () -> Unit = {}
) {
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        var squarePosition by remember {
            mutableStateOf(
                randomOffsetSquare(edge=edge,
                    width = constraints.maxWidth,
                    height = constraints.maxHeight
                )
            )
        }
        val squareSize = edge

        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(enabled) {
                    if (!enabled) {
                        return@pointerInput
                    }

                    detectTapGestures { offset ->
                        val left = squarePosition.x
                        val right = squarePosition.x + squareSize
                        val top = squarePosition.y
                        val bottom = squarePosition.y + squareSize

                        if (offset.x >= left && offset.x <= right && offset.y >= top && offset.y <= bottom) {

                            squarePosition = randomOffsetSquare(
                                edge=edge,
                                width = constraints.maxWidth,
                                height = constraints.maxHeight
                            )
                            onSquareClick()
                        }
                    }

                }
        ) {
            drawRect(
                color = squareColor,
                topLeft = squarePosition,
                size= Size(width = edge.toFloat(), height = edge.toFloat()),
                alpha = 0.7f,
                style = Fill,




            )
        }
    }
}
private fun randomOffsetSquare(edge: Int,width: Int, height: Int): Offset {
    return Offset(
        x = Random.nextInt(0, width-edge).toFloat(),
        y = Random.nextInt(0, height-edge).toFloat()
    )
}
