package com.kotlin.demo02.extend

import java.lang.StringBuilder

fun main() {
    var s:String = "abc-"
    println(s.times(5))
    println(s.a)
    println("========")

    println("abc" * 16)
    "abc".b = 5
    println("abc".b)
}

operator fun String.times(int: Int):String{
    val stringBuffer = StringBuffer()
    for(i in 0 until int){
        stringBuffer.append(this)
    }
    return stringBuffer.toString()
}

val String.a:String
    get() = "*abc*"

var String.b:Int
    set(value) {}
    get() = 5