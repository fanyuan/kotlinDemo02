package com.kotlin.demo02

enum class LogLevel(val id : Int){
    LEVEL1(1),LEVEL2(2),LEVEL3(3),LEVEL4(4),LEVEL5(5);
    fun getTag():String{
        return "$name , $ordinal"
    }
    override fun toString(): String {
        return "name=$name-ordinal=$ordinal-id=$id"
    }
}

fun main() {
    println(LogLevel.LEVEL2.ordinal)
    LogLevel.values().map {ite -> println(ite)}
    println(LogLevel.valueOf("LEVEL3"))

}