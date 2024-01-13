package com.hasantuncay.canvas.ui.theme.canvasShapes

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DrawPoints(){

Canvas(modifier = Modifier.fillMaxSize(), onDraw = {




    drawPoints(
        points = listOf(
            Offset(100f, 100f),
            Offset(150f, 200f),
            Offset(200f, 300f),
            Offset(250f, 400f),
            Offset(300f, 500f),
            Offset(350f, 600f),

            Offset(600f, 100f),
            Offset(550f, 200f),
            Offset(500f, 300f),
            Offset(450f, 400f),
            Offset(400f, 500f),

        ),
        pointMode = PointMode.Points,
        brush = SolidColor(Color.Red),
        strokeWidth = 50f,
        cap = StrokeCap.Butt,
        pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f),
        alpha = 0.8f,
        colorFilter = ColorFilter.tint(Color.Blue),
        blendMode = BlendMode.SrcOver
    )

    drawPoints(
        points = listOf(

            Offset(150f, 800f),

            Offset(400f, 1300f),


            Offset(650f, 800f),

            Offset(400f, 1300f),


            ),
        pointMode = PointMode.Lines,
        brush = SolidColor(Color.Red),
        strokeWidth = 50f,
        cap = StrokeCap.Butt,
        pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f),
        alpha = 0.8f,
        colorFilter = ColorFilter.tint(Color.Blue),
        blendMode = BlendMode.SrcOver
    )

    drawPoints(
        points =listOf(
            Offset(100f, 1400f), // 1. corner
            Offset(400f, 1900f), // 2. corner
            Offset(700f, 1400f), // 3. corner
            Offset(100f, 1400f)  // 4.  corner
        ),
        pointMode = PointMode.Polygon,
        brush = SolidColor(Color.Red),
        strokeWidth = 30f,
        cap = StrokeCap.Round,
        pathEffect = PathEffect.dashPathEffect(floatArrayOf(5f, 45f), 15f),
        alpha = 0.8f,
        colorFilter = ColorFilter.tint(Color.Blue),
        blendMode = BlendMode.SrcOver
    )

}
)
}
@Preview(showBackground = true)
@Composable
fun PreviewCanvasShapes() {
    DrawPoints()
}
