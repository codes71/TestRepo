package com.example.myproject

open class Animals(
    val aName : String,
    val sound : String,
    val color:String,
    val legs:Int){
    fun walk(manner : String){
        println("$aName is walking $manner ")
    }
    fun  makeSound(){
        println("$aName is making $sound ")
    }
    fun eat(){

    }
}
class Mammal(
    val name : String,
    val Nipples: Int,
    val noOfLegs : Int,
    val twoLegged : Boolean,
    val mammalColor : String,
    val aSound: String
) : Animals( aName = name ,color= mammalColor, legs = noOfLegs,sound = aSound)
{
    fun Birth(){

    }
    fun BreastFeeding(){

    }
}
fun add(var a, val b){

}
fun main(){
    val cow = Mammal(
        mammalColor = "White",
        aSound = "Moo",
        name="Cow",
        Nipples = 4,
        noOfLegs = 4,
        twoLegged = false,
    )
    cow.walk("Slowly")
    cow.walk("normally")

    cow.makeSound()
}