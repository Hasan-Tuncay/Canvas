package com.hasantuncay.canvas.canvasShapes

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.drawscope.DrawScope.Companion.DefaultBlendMode
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DrawRoundRect() {
    Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
        val width=  300.dp.toPx()
        val   height = 150.dp.toPx()
        val size = Size(width = width, height = height)
        val     topLeft1 = Offset(x = 100f, y = height)
        val     topLeft2 = Offset(x = 100f, y = (height*2.5).toFloat())
        val     topLeft3 = Offset(x = 100f, y = (height*4).toFloat())
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
        drawRoundRect(
            brush =brush,
            topLeft    =  topLeft1,
        size  =  size,
        cornerRadius  = CornerRadius(x = 25f, y = 25f),
        style  = Fill,

        alpha = 1.0f,
        colorFilter = null,
        blendMode = DefaultBlendMode
        )
        drawRoundRect(
            brush =brush,
            topLeft    =  topLeft2,
            size  =  size,
            cornerRadius  = CornerRadius(x = 1500f, y = 300f),
            style  = Fill,

            alpha = 1.0f,
            colorFilter = null,
            blendMode = DefaultBlendMode
        )
        drawRoundRect(
            brush =brush,
            topLeft    =  topLeft3,
            size  =  size,
            cornerRadius  = CornerRadius(x = 75f, y = 150f),
            style  = Fill,

            alpha = 1.0f,
            colorFilter = null,
            blendMode = DefaultBlendMode
        )

    })
}
@Preview(showBackground = true)
@Composable
fun drawRoundRect(){
    DrawRoundRect()
}