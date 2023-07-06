package com.example.myproject

class song(val sname : String,val duration : String, val url : String,val artist : String){
    fun play(){
        println("Playing the song $sname...")
    }
    fun pause(){
        println("Opps, Music $sname is paused")
    }
    fun prev(){
        println("Going to previous")
    }
    fun nextm(){
        println("Leaving soon? Going to next")
    }
}

fun main(){
    val Angel = song("Promise","2:31","https://open.spotify.com/track/2RUcwyW74Sv4VracHFrKdh?si=3a76b1f2b9cf476a","Jinmin")
    println(Angel.play())
    println(Angel.pause())
    Angel.nextm()
}