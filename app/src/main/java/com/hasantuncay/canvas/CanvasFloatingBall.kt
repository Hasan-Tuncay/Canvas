package com.hasantuncay.canvas

import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.withFrameMillis
import androidx.compose.ui.Modifier

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.random.Random

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CanvasCircleClick() {
    var velocity by remember { mutableStateOf(Offset(5f, 5f)) }
    var radius by remember {
        mutableStateOf(150f)
    }
    val coroutine = rememberCoroutineScope()
    val previousPositions = mutableListOf<Offset>()
    val configuration = LocalConfiguration.current
    val density = LocalDensity.current.density

    // Convert screen dimensions from dp to px
    val screenWidthPx = configuration.screenWidthDp * density
    val screenHeightPx = configuration.screenHeightDp * density

    var ballPosition by remember { mutableStateOf(Offset(screenWidthPx / 2, screenHeightPx / 2)) }
    var ballcolor by remember { mutableStateOf(Color.Red) }
    var previousColor by remember { mutableStateOf(Color.White) }
    var enabled by remember {
        mutableStateOf(true)
    }
    var indexx = 0
    LaunchedEffect(Unit, key2 = enabled) {


        while (enabled) {
            withFrameMillis { frameTimeMillis ->
                Log.d("CanvasCircleClick", "CanvasCircleClick: $frameTimeMillis")
                val frameTimeSeconds: Float =
                    frameTimeMillis / 100000000f  // Corrected time calculation
                Log.d("CanvasCircleClick", "frameTimeSeconds: $frameTimeSeconds")
                //   ballPosition += velocity * frameTimeSeconds  // Update position
                var newX = ballPosition.x + velocity.x
                var newY = ballPosition.y + velocity.y
                Log.d("CanvasCircleClick", "ballPosition: $ballPosition")
                // Check bounds for X axis and reverse velocity if necessary
                if (newX - radius < 0 || newX + radius > screenWidthPx) {
                    velocity = velocity.copy(x = -velocity.x)
                    newX = max(radius, min(screenWidthPx - radius, newX))
                }

                // Check bounds for Y axis and reverse velocity if necessary
                if (newY - radius < 0 || newY + radius > screenHeightPx) {
                    velocity = velocity.copy(y = -velocity.y)
                    newY = max(radius, min(screenHeightPx - radius, newY))
                }


                ballPosition = Offset(newX, newY)
            }
        }
    }

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(previousColor)
    ) {

        Canvas(modifier = Modifier
            .fillMaxSize()
            .pointerInput(enabled) {

                detectTapGestures {


                    val distance = sqrt(
                        (it.x - ballPosition.x).pow(2) +
                                (it.y - ballPosition.y).pow(2)
                    )
                    if (distance <= radius) {
                        previousColor = ballcolor
                        ballcolor = getRandomDistinctPredefinedColor(ballcolor)


                        Log.d("enabled", "enabled: $enabled ")
                        // Set the radius to half of the screen's diagonal to cover the entire screen
                        ballPosition = Offset(
                            Random
                                .nextInt(0, (screenWidthPx - radius).toInt())
                                .toFloat(),
                            Random
                                .nextInt(0, (screenHeightPx - radius).toInt())
                                .toFloat()
                        )

                        Log.d(
                            "CanvasCircleClick",
                            "CanvasCircleClick: ${
                                Offset(
                                    screenWidthPx / 2,
                                    screenHeightPx / 2
                                )
                            }"
                        )

                    }
                }
            }, onDraw = {
            val brushColor = Brush.radialGradient(
                colors = listOf(Color.Red, Color.White),
                center = Offset(screenWidthPx, screenHeightPx),
                radius = radius,
                tileMode = TileMode.Clamp
            )
//            // Draw shadows for previous positions
//            for ((index, position) in previousPositions.withIndex()) {
//                Log.d("CanvasCircleClick", "previousPositions.withIndex(): $previousPositions")
//                val alpha = 1f - (index.toFloat() / previousPositions.size)
//                drawContext.canvas.nativeCanvas.apply {
//                    drawCircle(
//                        position.x, position.y, radius, Paint().apply {
//                            color = android.graphics.Color.RED
//                            setStyle(Paint.Style.FILL)
//                            setShadowLayer(
//                                60f,
//                                0f,
//                                0f,
//                                android.graphics.Color.argb((50 * alpha).toInt(), 0, 0, 0)
//                            )
//                        }
//                    )
//                }
//            }

            //  Draw the actual ball
//            drawContext.canvas.nativeCanvas.apply {
//                drawCircle(
//                    ballPosition.x, ballPosition.y, radius, Paint().apply {
//                        color = android.graphics.Color.RED
//                        setStyle(Paint.Style.FILL)
//                    }
//                )
//            }
            drawCircle(
                ballcolor,
                radius,
                ballPosition
            )

        })
    }

}


fun getRandomDistinctPredefinedColor(previousColor: Color): Color {
    val predefinedColors = listOf(
        Color.Red, Color.Green, Color.Blue,
        Color.Yellow, Color.Cyan, Color.Magenta,
        Color.Black, Color.Gray,
        // Add more predefined colors if needed
    )

    var newColor: Color
    do {
        // Randomly select a color from the list
        newColor = predefinedColors[Random.nextInt(predefinedColors.size)]
    } while (newColor == previousColor)

    return newColor
}

@Preview(showBackground = true)
@Composable
fun PreviewCircle() {
    CanvasCircleClick()
}
