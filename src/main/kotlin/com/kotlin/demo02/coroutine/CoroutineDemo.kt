package com.kotlin.demo02.coroutine

import javafx.application.Application.launch
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    println("===========")
//    println("开始 线程id:${Thread.currentThread().id}")
//    val job = GlobalScope.launch {
//        println("协程执行体$this  线程id:${Thread.currentThread().id}")
//        delay(100)
//
//    }
//
//    println("结束 线程id:${Thread.currentThread().id}")
    GlobalScope.launch {
        println("协程执行体$this  线程id:${Thread.currentThread().id}")
    }
}
fun runBlockingTest() = runBlocking {
    repeat(5){
        println("协程执行体$this  线程id:${Thread.currentThread().id}")
        delay(100)
    }

}
fun runBlockingTest01() = runBlocking {
    println("开始 线程id:${Thread.currentThread().id}")
    runBlockingTest()
    Thread(){
        run {
            println("开始 线程id:${Thread.currentThread().id}")
            runBlockingTest()
            println("结束 线程id:${Thread.currentThread().id}")
        }
    }.start()
    println("结束 线程id:${Thread.currentThread().id}")
}