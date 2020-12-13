package com.kotlin.demo02.coroutine

import kotlin.coroutines.Continuation
import kotlin.coroutines.startCoroutine

fun main() {

}

fun coroutine01(block:suspend () -> Unit){
    block.startCoroutine(Continuation<Unit>())
}