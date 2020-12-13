package com.kotlin.demo02

class Latitude private constructor(val value:Double){

    companion object{
        @JvmField
        val TAG:String = "Latitude"
        @JvmStatic
        fun ofDouble(double: Double):Latitude{
            return Latitude(double)
        }
        fun ofLatitude(latitude: Latitude):Latitude{
            return Latitude(latitude.value)
        }
    }
}

fun main() {
    val latitude01 = Latitude.ofDouble(3.0)
    var latitude02 = Latitude.ofLatitude(latitude01)
    println(latitude01.value)
    println(Latitude.TAG)
    println(latitude02.value)

}