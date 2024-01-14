package com.hasantuncay.canvas.ui.theme.canvasShapes

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DrawLine() {
    val startOffset = Offset(x = 300f, y = 500f)
    val endOffset = Offset(x = 300f, y = 1000f)
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

        start = startOffset,
        end = endOffset,
        tileMode = TileMode.Repeated,
    )
    Canvas(modifier = Modifier.fillMaxSize(), onDraw = {


        drawLine(
            brush = brush,
            start = Offset(x = 100f, y = 500f),
            end = Offset(x = 100f, y = 1000f),
            strokeWidth = 49f,
            cap = StrokeCap.Square,
            pathEffect = PathEffect.dashPathEffect(floatArrayOf(34f, 34f), 0f),
            alpha = 0.6f,
            colorFilter = null,
            blendMode = BlendMode.Clear
        )
        drawLine(
            brush = brush,
            start = Offset(x = 200f, y = 500f),
            end = Offset(x = 200f, y = 1000f),
            strokeWidth = 49f,
            cap = StrokeCap.Square,
            pathEffect = PathEffect.dashPathEffect(floatArrayOf(34f, 34f), 0f),
            alpha = 1f,
            colorFilter = null,
            blendMode = BlendMode.DstOut
        )
        drawLine(
            brush = brush,
            start = Offset(x = 300f, y = 500f),
            end = Offset(x = 300f, y = 1000f),
            strokeWidth = 23f,
            cap = StrokeCap.Square,
            pathEffect = PathEffect.dashPathEffect(floatArrayOf(0f, 0f), 0f),
            alpha = 1f,
            colorFilter = null,
            blendMode = BlendMode.SrcOver
        )
        drawLine(
            brush = brush,
            start = Offset(x = 400f, y = 500f),
            end = Offset(x = 400f, y = 1000f),
            strokeWidth = 49f,
            cap = StrokeCap.Round,
            pathEffect = PathEffect.dashPathEffect(floatArrayOf(0f, 0f), 0f),
            alpha = 1f,
            colorFilter = null,
            blendMode = BlendMode.SrcOver
        )
        drawLine(
            brush = brush,
            start = Offset(x = 500f, y = 500f),
            end = Offset(x = 500f, y = 1000f),
            strokeWidth = 49f,
            cap = StrokeCap.Butt,
            pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 34f), 0f),
            alpha = 1f,
            colorFilter = null,
            blendMode = BlendMode.SrcOver
        )
        drawLine(
            brush = brush,
            start = Offset(x = 600f, y = 500f),
            end = Offset(x = 600f, y = 1000f),
            strokeWidth = 49f,
            cap = StrokeCap.Butt,
            pathEffect = PathEffect.dashPathEffect(floatArrayOf(0f, 0f), 0f),
            alpha = 1f,
            colorFilter = null,
            blendMode = BlendMode.SrcOver
        )

        drawLine(
            brush = brush,
            start = Offset(x = 700f, y = 500f),
            end = Offset(x = 700f, y = 1000f),
            strokeWidth = 49f,
            cap = StrokeCap.Butt,
            pathEffect = PathEffect.dashPathEffect(floatArrayOf(0f, 0f), 0f),
            alpha = 0.3f,
            colorFilter = ColorFilter.tint(Color.Black),
            blendMode = BlendMode.SrcOver
        )

    }

    )
}


@Preview(showBackground = true)
@Composable
fun DrawLinePreview() {
    DrawLine()
}