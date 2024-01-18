package com.hasantuncay.canvas.ballClicker

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


fun countdownTimer(
    time: Int = 30000,
    isTimerRunning: Boolean = false,
    onCurrentTime : (Int)->Unit= {},
    onTimerEnd: () -> Unit = {}
) {
    var currentTime  = 0
  CoroutineScope(Dispatchers.IO).launch {
      if(!isTimerRunning) {
          currentTime = time
          return@launch
      }
      if(currentTime > 0) {
          delay(1000L)
          currentTime -= 1000
          onCurrentTime(currentTime)
      } else {
          onTimerEnd()
      }
  }



}