package com.hasantuncay.canvas.canvasShapes

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.DrawScope.Companion.DefaultBlendMode
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DrawPath() {
    Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
        val color = Color.Blue













            val moveToPath = Path().apply {
                moveTo(100f, 100f)
                lineTo(100f, 150f)
                lineTo(50f, 150f)
                lineTo(50f, 100f)
                close()
            }
            drawPath(
                path = moveToPath,
                color = color,
                style = Fill, // Only one path use stroke fill doesnt work
                alpha = 1.0f,
                colorFilter = null,
                blendMode = DefaultBlendMode
            )

            val lineToPath = Path().apply {
                moveTo(150f, 100f)
                lineTo(150f, 200f)
                close()
            }
            drawPath(
                path = lineToPath,
                color = color,
                style = Stroke(10f),
                alpha = 1.0f,
                colorFilter = null,
                blendMode = DefaultBlendMode
            )
            val quadraticBezierPath = Path().apply {
                moveTo(550f, 100f)
                quadraticBezierTo(650f, 50f, 750f, 100f)
            }
            drawPath(
                path = quadraticBezierPath,
                color = color,
                style = Stroke(10f),
                alpha = 1.0f,
                colorFilter = null,
                blendMode = DefaultBlendMode
            )
//Bezier Curves
// https://web.archive.org/web/20150414092649/http://bilgisayarkavramlari.sadievrenseker.com/2009/10/31/bezier-egrileri-bezier-curves/
            val cubicToPath = Path().apply {
                moveTo(350f, 100f)
                cubicTo(400f, 50f, 450f, 150f, 500f, 100f)
            }
            val cubicToPath2 = Path().also {
                it.moveTo(350f, 100f)
                it.cubicTo(400f, 50f, 450f, 150f, 500f, 100f)
            }
            val cubicToPath3 = Path()
            cubicToPath.moveTo(350f, 100f)
            cubicToPath.cubicTo(400f, 50f, 450f, 150f, 500f, 100f)

            drawPath(
                path = cubicToPath,
                color = color,
                style = Stroke(10f),
                alpha = 1.0f,
                colorFilter = null,
                blendMode = DefaultBlendMode
            )


        val arcToPath = Path().apply {
            arcTo(Rect(100f, 200f, 200f, 300f), 0f, 135f, false)}


        drawPath(
            path = arcToPath,
            color = color,
            style = Stroke(10f),
            alpha = 1.0f,
            colorFilter = null,
            blendMode = DefaultBlendMode
        )

        val rectPath = Path().apply {
            addRect(Rect(300f, 200f, 600f, 300f))
        }


        drawPath(
            path = rectPath,
            color = color,
            style = Stroke(10f),
            alpha = 1.0f,
            colorFilter = null,
            blendMode = DefaultBlendMode
        )

        val ovalPath = Path().apply {
            addOval(Rect(650f, 200f, 800f, 300f))
        }
        drawPath(
            path = ovalPath,
            color = color,
            style = Stroke(10f),
            alpha = 1.0f,
            colorFilter = null,
            blendMode = DefaultBlendMode
        )
        val addArcPath = Path().apply {
            addArc(Rect(100f, 400f, 200f, 500f), 0f, 180f)
        }
        drawPath(
            path = addArcPath,
            color = color,
            style = Stroke(10f),
            alpha = 1.0f,
            colorFilter = null,
            blendMode = DefaultBlendMode
        )
        val roundRectPath = Path().apply {
            addRoundRect(RoundRect(Rect(250f, 400f, 400f, 600f), 10f, 10f))
        }
        drawPath(
            path = roundRectPath,
            color = color,
            style = Stroke(10f),
            alpha = 1.0f,
            colorFilter = null,
            blendMode = DefaultBlendMode
        )
        val path1 = Path().apply { moveTo(600f,600f, ); lineTo(800f, 700f) }
        val addPathPath = Path().apply {
            addPath(path1, Offset(0f, 50f))
        }
        drawPath(
            path = addPathPath,
            color = color,
            style = Stroke(10f),
            alpha = 1.0f,
            colorFilter = null,
            blendMode = DefaultBlendMode
        )

        val resetPath = Path().apply {
            moveTo(100f, 700f)
            lineTo(100f, 600f)
        }

        drawPath(
            path = resetPath,
            color = color,
            style = Stroke(10f),
            alpha = 1.0f,
            colorFilter = null,
            blendMode = DefaultBlendMode
        )

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



    })




}

@Preview(showBackground = true)
@Composable
fun DrawPathPreview() {
    DrawPath()
}
