package com.kotlin.demo02.sealedClass

sealed class Mathematics{
    data class Dou(val num:Double):Mathematics()
    data class Sub(val e1:Mathematics,val e2:Mathematics):Mathematics()
    object NotANumber:Mathematics()
    fun eval(m:Mathematics):Double = when(m){

            is Dou -> m.num
            is Sub -> {eval(m.e1) - eval(m.e2)}
            NotANumber -> Double.NaN

    }
}

fun main() {
    var ec1:Mathematics = Mathematics.Dou(5.0)
    val d1 = ec1.eval(ec1)
    println("d1 = " + d1)
    var ec2:Mathematics = Mathematics.Sub(ec1,Mathematics.Dou(3.0))
    var d2 = ec2.eval(ec2)
    println("d2 = " + d2)
    d2 = ec1.eval(ec2)
    println("d2 = " + d2)
    var ec3:Mathematics = Mathematics.NotANumber
    var d3 = ec3.eval(ec3)
    println("d3 = " + d3)
    var ec = Mathematics.NotANumber
    d3 = ec.eval(ec)
    println("d3 = " + d3)
}