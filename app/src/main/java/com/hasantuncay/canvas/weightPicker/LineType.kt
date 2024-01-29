package com.hasantuncay.canvas.weightPicker

sealed class LineType(){
    object Normal : LineType()

    object FiveStep :LineType()
    object TenStep : LineType()
}
