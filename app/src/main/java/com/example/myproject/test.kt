package com.example.myproject

class working(val name : String){
    fun sleep(){
        println("$name a lazy bum!")
    }
    fun code(){
        println("$name coding now" )
    }

}
fun main(){
    val ubh="Thura"
    var abc=24.5f
    val code1 = working("Thura is")
    code1.sleep()
    println(abc.toInt())
}