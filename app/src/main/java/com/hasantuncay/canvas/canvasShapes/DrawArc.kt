package com.hasantuncay.canvas.canvasShapes

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.drawscope.DrawScope.Companion.DefaultBlendMode
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun DrawArc(){


    Canvas(Modifier.fillMaxSize()) {
        val width=  350.dp.toPx()
        val   height = 150.dp.toPx()
        val size = Size(width = width, height = height)
        val brush = Brush.linearGradient(
            colors = listOf(
                Color.Red,
                Color(-0x5b00),
                Color.Yellow,
                Color.Green,
                Color.Blue,
                Color(-0xb4ff7e),
                Color.Magenta
            ),
            start= Offset(x = 100f, y = 500f),
            end= Offset(x = 100f+width, y = 500f),
            tileMode = TileMode.Clamp,
        )
        drawArc(
            brush=brush,
            startAngle=90f,
            sweepAngle=180f,
            useCenter=true,
            topLeft=  Offset(x = 100f, y = 500f),
        size=size,     /*@FloatRange(from = 0.0, to = 1.0)*/
        alpha = 1.0f,
        style  = Fill,
        colorFilter = null,
        blendMode = DefaultBlendMode)
//counter-clockwise
        drawArc(
            brush=brush,
            startAngle=90f,
            sweepAngle=270f,
            useCenter=true,
            topLeft=  Offset(x = 100f, y = 1500f),
            size=size,
            alpha = 1.0f,
            style  = Stroke(width = 10f),
            colorFilter = null,
            blendMode = DefaultBlendMode)
    }
}

@Preview(showBackground = true)
@Composable
fun DrawArcPreview(){
    DrawArc()
}