package com.example.enigma_music_player.common

/**
 * Created by Maulana Ibrahim on 21/August/2020
 * Email maulibrahim19@gmail.com
 */

fun convertTimeString(time:String):String{
    val second = time.toLong() % 60
    val minutes = (time.toLong() / 60) % 60
    return String.format("%d:%02d",minutes,second)
}