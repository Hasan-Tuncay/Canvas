package com.hasantuncay.canvas.weightPicker

import android.health.connect.datatypes.units.Length
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class ScaleStyle(
    val scaleWidth: Dp = 100.dp,
    val radius: Dp= 550.dp,
    val normalLineColor  :Color= Color.LightGray,
    val fiveStepColor :Color=Color.Green,
    val tenStepColor:Color=Color.Red,
    val normalLineLength: Dp=15.dp,
    val fiveLineLength: Dp=15.dp,
    val tenLineLength: Dp=15.dp,
    val scaleIndicatorColor:Color=Color.Green,
    val scaleIndicatorLength:Dp=60.dp,
    val textSize:TextUnit=18.sp
    )
