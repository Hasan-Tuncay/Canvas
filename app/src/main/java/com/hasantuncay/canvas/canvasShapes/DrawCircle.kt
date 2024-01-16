package com.hasantuncay.canvas.canvasShapes

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun DrawCircle() {
    val density = LocalDensity.current
    val configuration = LocalConfiguration.current


    //Screen width and height in dp
    val screenWidthDp = configuration.screenWidthDp.dp
    val screenHeightDp = configuration.screenHeightDp.dp


    //Screen width and height in pixel
    val screenWidthPx = with(density) { screenWidthDp.toPx() }
    val screenHeightPx = with(density) { screenHeightDp.toPx() }
    val boxHeight = screenHeightDp / 4

    val radius = minOf(
        screenWidthPx,
        screenHeightPx
    )
    val center = Offset(x = screenWidthPx / 2, y = screenHeightPx / 2)
    val colors = listOf(
        Color.Green,
        Color.White,
        Color.Red,
        Color.White,
        Color.Blue,
        Color.White,
        Color.Yellow
    )

    val solidColorBrush = SolidColor(Color.Red)

    val linearGradientBrush = Brush.linearGradient(
        colors = listOf(Color.Red, Color.Blue, Color.Red, Color.Blue),
        start =  Offset(x = screenWidthPx  , y = screenHeightPx / 2),
        end =  Offset(x = screenWidthPx / 3, y = screenHeightPx  ),


        )
    val radialGradientBrush = Brush.radialGradient(
        center = Offset.Unspecified,
        radius = radius,
        colors = colors
    )

    Canvas(modifier = Modifier
        .fillMaxSize()
        , onDraw =

        {




            drawCircle(
                brush = linearGradientBrush,
                radius = radius/2,
                center = Offset(x = screenWidthPx / 2, y = screenHeightPx -500 ),
                alpha = 0.6f,
                style = Fill,
                colorFilter = null,
                blendMode = DrawScope.DefaultBlendMode
            )








            drawCircle(
                color = Color.Black,
                radius = radius/7,
                center = Offset(x = screenWidthPx /2, y =  screenHeightPx -1000f),       //this.center,
                alpha = 0.6f,
                style = Fill,
                colorFilter = null,
                blendMode = DrawScope.DefaultBlendMode
            )




            drawCircle(
                brush = solidColorBrush,
                radius = radius/2,
                center = Offset(x = screenWidthPx / 2, y = screenHeightPx -1500),       //this.center,
                alpha = 0.6f,
                style = Fill,
                colorFilter = null,
                blendMode = DrawScope.DefaultBlendMode
            )



        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewCanvas() {
    DrawCircle()

}
