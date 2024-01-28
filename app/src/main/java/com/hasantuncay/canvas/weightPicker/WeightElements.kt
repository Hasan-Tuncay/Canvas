package com.hasantuncay.canvas.weightPicker

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset

import androidx.compose.ui.graphics.nativeCanvas
import android.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Scale(
    modifier: Modifier = Modifier,
    style: ScaleStyle = ScaleStyle(),
    minWeight: Int = 20,
    maxWeight: Int = 240,
    initialWeight: Int = 80,
    onWeightChangr: (Int) -> Unit

) {

    val scaleWidth = style.scaleWidth
    val radius = style.radius
    var center by remember {
        mutableStateOf(Offset.Zero)
    }
    var circleCenter by remember {
        mutableStateOf(Offset.Zero)
    }
    var angle by remember {
        mutableStateOf(0f)
    }
    Canvas(modifier = modifier) {
        center = this.center
        circleCenter = Offset(center.x, scaleWidth.toPx() / 2f + radius.toPx())
        val outerRadius = Offset(center.x, radius.toPx() + scaleWidth.toPx() / 2f)
        val innerRadius = Offset(center.x, radius.toPx() - scaleWidth.toPx() / 2f)
        drawContext.canvas.nativeCanvas.apply {
            drawCircle(
                circleCenter.x, circleCenter.y, radius.toPx(), Paint().apply {
                    strokeWidth = scaleWidth.toPx()
                    color = Color.WHITE
                    setStyle(Paint.Style.STROKE)
                    setShadowLayer(
                         60f,
                       0f,
                        0f,
                        Color.argb(50, 0, 0, 0)
                    )

                }
            )
        }
        //Draw Lines
        for (i in minWeight..maxWeight){
val angleInRadian=(i-initialWeight+angle-90)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScalePreview(){
    Scale(  ){}
}