package com.hasantuncay.canvas.canvasShapes

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.nativeCanvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.Typeface
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.hasantuncay.canvas.R
import com.hasantuncay.canvas.ui.theme.Typography

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DrawText() {
    val context= LocalContext.current
    val sampleText = "Canvas DrawText Sample"


    val textStyle = MaterialTheme.typography.bodyLarge.fontFamily
    Canvas(modifier = Modifier.fillMaxSize()) {
        drawContext.canvas.nativeCanvas.apply {
            val paint = Paint().apply {
                color = android.graphics.Color.BLACK
                textSize = 24.sp.toPx()
                textAlign = Paint.Align.LEFT
            }

            val bounds = Rect().apply {
                paint.getTextBounds(sampleText, 0, sampleText.length, this)
            }

            drawText(sampleText, 150f, 345f, paint)
        }

        drawContext.canvas.nativeCanvas.apply {

            val timesNewRomanFontFamily = FontFamily(Font(R.font.phenomena_black))

            val paint = Paint().apply {
                color = android.graphics.Color.BLACK // Renk
                typeface = Typeface.create(
                    "phenomena_black", // Font adı
                    Typeface.ITALIC // FontStyle (NORMAL, BOLD, ITALIC, vb.)
                )
                textSize = 24.sp.toPx() // Font boyutunu sp'den px'e çevirme
                textAlign = Paint.Align.LEFT // Metin hizalaması
                // Diğer Paint ayarları buraya eklenebilir
            }

            val bounds = Rect().apply {
                paint.getTextBounds(sampleText, 0, sampleText.length, this)
            }

            // Metni çizmek için drawText kullanımı
            drawText(sampleText, 150f, 545f, paint)

        }
        var typeface2 = Typeface.create(
            context.resources.getFont(R.font.phenomena_thin),
            Typeface.BOLD_ITALIC
        )

        drawContext.canvas.nativeCanvas.apply {



            val paint = Paint().apply {
                color = android.graphics.Color.BLACK // Renk
                typeface = typeface2
                textSize = 24.sp.toPx() // Font boyutunu sp'den px'e çevirme
                textAlign = Paint.Align.LEFT // Metin hizalaması
                // Diğer Paint ayarları buraya eklenebilir
            }

            val bounds = Rect().apply {
                paint.getTextBounds(sampleText, 0, sampleText.length, this)
            }

            // Metni çizmek için drawText kullanımı
            drawText(sampleText, 150f, 745f, paint)

        }
        var typeface3 = Typeface.create(
            context.resources.getFont(R.font.phenomena_extrabold),
            Typeface.NORMAL
        )

        drawContext.canvas.nativeCanvas.apply {



            val paint = Paint().apply {
                color = android.graphics.Color.BLACK // Renk
                typeface = typeface3
                textSize = 24.sp.toPx() // Font boyutunu sp'den px'e çevirme
                textAlign = Paint.Align.LEFT // Metin hizalaması
                // Diğer Paint ayarları buraya eklenebilir
            }

            val bounds = Rect().apply {
                paint.getTextBounds(sampleText, 0, sampleText.length, this)
            }

            // Metni çizmek için drawText kullanımı
            drawText(sampleText, 150f, 945f, paint)

        }
    }

}
    @RequiresApi(Build.VERSION_CODES.O)
    @Preview(showBackground = true)
    @Composable
    fun DrawTExtPreview() {
        DrawText()
    }