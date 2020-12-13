package com.kotlin.demo02

class House

class Flower

class Countyard{
    private val house:House = House()
    private val flower:Flower = Flower()
}

class ForbiddenCity{
    internal val houses = arrayOf(House(), House())
    val flowers = arrayOf(Flower(),Flower())
}
fun main() {
    val countyard = Countyard()
    //println("countyard.flower = ${countyard.flower}")
    //println("countyard.house = ${countyard.house}")
    val fc = ForbiddenCity()
    println("fc.flowers = ${fc.flowers} size = ${fc.flowers.size}")
    println("fc.houses = ${fc.houses} size = ${fc.houses.size}")
}