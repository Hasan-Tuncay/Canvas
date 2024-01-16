package com.hasantuncay.canvas.canvasShapes

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DrawRect(){
val color= Color.Blue

    Canvas(modifier = Modifier.fillMaxSize(), onDraw ={
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
            end=Offset(x = 100f+width, y = 500f),
            tileMode = TileMode.Clamp,
        )
        drawRect(
            brush = brush,
            topLeft = Offset(x = 100f, y = 500f),
            size = size ,

        style = Fill, // or stroke
            alpha = 1f,
            colorFilter = null,
            blendMode = BlendMode.SrcOver)
        drawRect(
            color = color,
            topLeft = Offset(x = 124f, y = 1234f),
            size = Size(width = 200.dp.toPx(), height = 346.dp.toPx()) ,

            style = Fill, // or stroke
            alpha = 1f,
            colorFilter = null,
            blendMode = BlendMode.SrcOver)
    } )
}
@Preview(showBackground = true)
@Composable
fun DrawRectPreview(){
    DrawRect()
}
