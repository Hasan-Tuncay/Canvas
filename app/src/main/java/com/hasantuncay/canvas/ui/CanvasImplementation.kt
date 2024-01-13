package com.hasantuncay.canvas.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.drawscope.DrawScope.Companion.DefaultBlendMode
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun CanvasModifier() {
    val density = LocalDensity.current
    val configuration = LocalConfiguration.current


    //Screeb width and height in dp
    val screenWidthDp = configuration.screenWidthDp.dp
    val screenHeightDp = configuration.screenHeightDp.dp


    //Screeb width and height in pixel
    val screenWidthPx = with(density) { screenWidthDp.toPx() }
    val screenHeightPx = with(density) { screenHeightDp.toPx() }
val boxHeight=screenHeightDp/4

    val radius = minOf(
        screenWidthPx,
        screenHeightPx
    ) /5
    val center = Offset(x = screenWidthPx / 2, y = screenHeightPx / 2)
val colors=listOf(
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
        colors = listOf(Color.Red, Color.Blue,Color.Red, Color.Blue),


    )
    val radialGradientBrush = Brush.radialGradient(
        center =  Offset.Unspecified,
        radius = radius,
        colors = colors
    )

    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .height(boxHeight)
            .drawBehind {
                drawCircle(
                    brush = radialGradientBrush,
                    radius = radius,
                    center = this.center,
                    alpha = 0.6f,
                    style = Fill,
                    colorFilter = null,
                    blendMode = DefaultBlendMode
                )


            })
        Box(modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .height(boxHeight)
            .drawBehind {
                drawCircle(
                    brush = linearGradientBrush,
                    radius = radius,
                    center = this.center,
                    alpha = 0.6f,
                    style = Fill,
                    colorFilter = null,
                    blendMode = DefaultBlendMode
                )


            })
        Box(modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .height(boxHeight)
            .drawBehind {
                drawRect(
                    brush = linearGradientBrush,

                    alpha = 0.6f,
                    style = Fill,
                    colorFilter = null,
                    blendMode = DefaultBlendMode
                )


            })

        Box(modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .height(boxHeight)
            .drawBehind {

                drawCircle(
                    color = Color.Black,
                    radius = radius,
                    center = this.center,       //this.center,
                    alpha = 0.6f,
                    style = Fill,
                    colorFilter = null,
                    blendMode = DefaultBlendMode
                )


            })
        Box(modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .height(boxHeight)
            .drawBehind {

                drawCircle(
                    brush = solidColorBrush,
                    radius = radius,
                    center = this.center,       //this.center,
                    alpha = 0.6f,
                    style = Fill,
                    colorFilter = null,
                    blendMode = DefaultBlendMode
                )


            })
    }


}

@Preview(showBackground = true)
@Composable
fun PreviewCanvas() {
    CanvasModifier()
}
