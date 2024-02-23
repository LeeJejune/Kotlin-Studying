package org.jjlee.kotlin.example

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch { doWorld() }
    println("Hello")
}

// this first suspending function
suspend fun doWorld() {
    delay(1000L)
    println("World!")
}
