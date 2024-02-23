package org.jjlee.kotlin.example

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    doWorld2()
    println("Done")
}

suspend fun doWorld2() = coroutineScope {
    launch {
        delay(1000)
        println("World!")
    }
    launch {
        delay(2000)
        println("World2!")
    }
    println("Hello")
}