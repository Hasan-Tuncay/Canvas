package com.hasantuncay.canvas.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.drawscope.DrawScope.Companion.DefaultBlendMode
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun CanvasModifier(){
    val radius= 400f
    val center = Offset( x=400f,y=1000f)
    val solidColorBrush = SolidColor(Color.Red)

    val linearGradientBrush = Brush.linearGradient(
        colors = listOf(Color.Red, Color.Blue),
        start = Offset(0f, 0f),
        end = Offset(100f, 100f)
    )
    val radialGradientBrush = Brush.radialGradient(
        center=center,
        radius=radius,
        colors = listOf(Color.Green,Color.White, Color.Red,Color.White, Color.Blue, Color.White,Color.Yellow)
    )


    Box(modifier = Modifier.background(Color.LightGray)
        .fillMaxSize()
        .drawBehind {
            drawCircle(
                brush = radialGradientBrush,
                radius =radius,
                center =  center ,       //this.center,
                alpha = 0.6f,
                style = Fill,
                colorFilter = null,
                blendMode = DefaultBlendMode
            )

        })}

    @Preview(showBackground = true)
    @Composable
    fun PreviewCanvas() {
      CanvasModifier()
    }
