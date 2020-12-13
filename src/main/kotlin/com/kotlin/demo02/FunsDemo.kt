package com.kotlin.demo02

val sum:(x:Int,y:Int) -> Int = {x:Int,y:Int -> x + y}
val sum02:(Int,Int) -> Int = {x:Int,y:Int -> x + y}
fun applyOp(x:Int,y:Int,op:(Int,Int) -> Int):Int = op(x,y)
fun main() {
    println(sum(2,3))
    var v1 = applyOp(3,5, sum)
    println("v1 = $v1")
    //var v2 = = applyOp(3,5,::sum)
}