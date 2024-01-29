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
import android.graphics.Paint.Style
import android.util.Log
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.withRotation
import com.hasantuncay.canvas.canvasShapes.DrawLine
import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.roundToInt
import kotlin.math.sin

@Composable
fun Scale(
    modifier: Modifier = Modifier,
    style: ScaleStyle = ScaleStyle(),
    minWeight: Int = 20,
    maxWeight: Int = 240,
    initialWeight: Int = 80,
    onWeightChange: (Int) -> Unit

) {
var pointerKey by remember {
    mutableStateOf(true)
}
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
    var dragStartedAngle by remember {
        mutableStateOf(0f)
    }
    var oldAngle by remember {
        mutableStateOf(angle)
    }
    Canvas(modifier = modifier
        .pointerInput(pointerKey) {
            detectDragGestures(
                onDragStart = { offset ->
                    dragStartedAngle = -atan2(
                        circleCenter.x - offset.x,
                        circleCenter.y - offset.y
                    ) * (180f / PI.toFloat())
                },
                onDragEnd = {
                    oldAngle = angle
                }
            ) { change, _ ->
                val touchAngle = -atan2(
                    circleCenter.x - change.position.x,
                    circleCenter.y - change.position.y
                ) * (180f / PI.toFloat())

                val newAngle = oldAngle + (touchAngle - dragStartedAngle)
                angle = newAngle.coerceIn(
                    minimumValue = initialWeight - maxWeight.toFloat(),
                    maximumValue = initialWeight - minWeight.toFloat()
                )
                onWeightChange((initialWeight - angle).roundToInt())
            }
        }
    ) {
        center = this.center
        circleCenter = Offset(
            center.x, scaleWidth.toPx() / 2f + radius.toPx()
        )
        val outerRadius = radius.toPx() + scaleWidth.toPx() / 2f
        val innerRadius = radius.toPx() - scaleWidth.toPx() / 2f
        drawContext.canvas.nativeCanvas.apply {
            drawCircle(circleCenter.x, circleCenter.y, radius.toPx(), Paint().apply {
                strokeWidth = scaleWidth.toPx()
                color = Color.WHITE
                setStyle(Paint.Style.STROKE)
                setShadowLayer(
                    60f, 0f, 0f, Color.argb(50, 0, 0, 0)
                )

            })
        }

        for (i in minWeight..maxWeight) {
            //kartezyen koordinat sisteminde baslangic noktaasi x- dogu 0 dir bunu 12 yonune almak icin 90 cikardik
            val angleInRadian = (i - initialWeight + angle - 90) * (PI / 180).toFloat()

            val lineType = when {
                i % 10 == 0 -> LineType.TenStep
                i % 5 == 0 -> LineType.FiveStep
                else -> {
                    LineType.Normal
                }

            }
            val lineColor = when (lineType) {
                LineType.Normal -> style.normalLineColor
                LineType.FiveStep -> style.fiveStepColor
                LineType.TenStep -> style.tenStepColor

            }
            val lineLength = when (lineType) {
                LineType.Normal -> style.normalLineLength.toPx()
                LineType.FiveStep -> style.fiveLineLength.toPx()
                LineType.TenStep -> style.tenLineLength.toPx()

            }
            val lineStart = Offset(
                x = ((outerRadius - lineLength) * cos(angleInRadian) + circleCenter.x).toFloat(),
                y = ((outerRadius - lineLength) * sin(angleInRadian) + circleCenter.y).toFloat()
            )
            val lineEnd = Offset(
                x = ((outerRadius) * cos(angleInRadian) + circleCenter.x).toFloat(),
                y = ((outerRadius) * sin(angleInRadian) + circleCenter.y).toFloat()
            )
            drawLine(lineColor, lineStart, lineEnd, strokeWidth = 1.dp.toPx())

            drawContext.canvas.nativeCanvas.apply {
                if (lineType is LineType.TenStep) {
                    val textRadius = outerRadius - lineLength - 5.dp.toPx() - style.textSize.toPx()
                    val x = textRadius * cos(angleInRadian) + circleCenter.x
                    val y = textRadius * sin(angleInRadian) + circleCenter.y
                    withRotation(
                        degrees = angleInRadian * (180f / PI.toFloat()) + 90f,
                        pivotX = x,
                        pivotY = y
                    ) {
                        drawText(
                            abs(i).toString(),
                            x,
                            y,
                            Paint().apply {
                                textSize = style.textSize.toPx()
                                textAlign = Paint.Align.CENTER
                            }
                        )
                    }

                }
            }
            drawLine(
                color = lineColor,
                start = lineStart,
                end = lineEnd,
                strokeWidth = 1.dp.toPx()
            )
            val middleTop = Offset(
                x = circleCenter.x,
                y = circleCenter.y - innerRadius - style.scaleIndicatorLength.toPx()
            )
            val bottomLeft = Offset(
                x = circleCenter.x - 4f,
                y = circleCenter.y - innerRadius
            )
            val bottomRight = Offset(
                x = circleCenter.x + 4f,
                y = circleCenter.y - innerRadius
            )
            val indicator = Path().apply {
                moveTo(middleTop.x, middleTop.y)
                lineTo(bottomLeft.x, bottomLeft.y)
                lineTo(bottomRight.x, bottomRight.y)
                lineTo(middleTop.x, middleTop.y)
            }
            drawPath(
                path = indicator,
                color = style.scaleIndicatorColor
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScalePreview() {
    Box(Modifier.fillMaxSize()) {
        Scale(
            style = ScaleStyle(scaleWidth = 150.dp), modifier = Modifier.align(Alignment.Center)
        ) { Log.d("ScalePreview", "ScalePreview: $it")}
    }

}