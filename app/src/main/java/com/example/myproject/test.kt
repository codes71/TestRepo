package com.example.myproject

class working(){
    var name=""
    fun sleep(){
        println("$name a lazy bum!")
    }
    fun code(){
        println("$name coding now" )
    }

}
fun main(){
    var u="Thura"
    var abc=24.5f;
    val code1 = working()

    code1.name="Thura is"
    code1.sleep()
    println(abc.toInt())
}