package com.hasantuncay.canvas.canvasShapes.path



import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathOperation
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.DrawScope.Companion.DefaultBlendMode
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PathOperations() {
    Canvas(modifier = Modifier
        .fillMaxSize()
        , onDraw = {


            val path = Path().apply {
                moveTo(500f, 1800f)
                lineTo(100f, 1500f)
                lineTo(500f, 1500f)
//                    quadraticBezierTo(800f, 300f, 500f, 100f)
                cubicTo(800f, 1500f, 800f, 1100f, 500f, 1100f)
            }
            drawPath(
                path = path,
                color = Color.Red,
                style = Stroke(
                    width = 10.dp.toPx(),
                    cap = StrokeCap.Round,
                    join = StrokeJoin.Miter,
                    miter = 0f
                )

            )

            val squareWithoutOp = Path().apply {
                addRect(Rect(Offset(200f, 2000f), Size(200f, 200f)))
            }
            val circle = Path().apply {
                addOval(Rect(Offset(200f, 2000f), 100f))
            }
            val pathWithOp = Path().apply {
                op(squareWithoutOp, circle, PathOperation.Xor)
            }
            drawPath(
                path = squareWithoutOp,
                color = Color.Red,
                style = Stroke(width = 2.dp.toPx())
            )
            drawPath(
                path = circle,
                color = Color.Blue,
                style = Stroke(width = 2.dp.toPx())
            )
            drawPath(
                path = pathWithOp,
                color = Color.Green,
            )


        })






}

@Preview(showBackground = true)
@Composable
fun PathOperationsPreview() {
    PathOperations()
}
