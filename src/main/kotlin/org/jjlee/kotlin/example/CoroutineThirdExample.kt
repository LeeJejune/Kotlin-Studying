package org.jjlee.kotlin.example

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() = runBlocking {
    space()
}

suspend fun space () = coroutineScope {
    val job = launch {
        delay(1000)
        println("World!")
    }
    println("Hello")
    job.join()
    println("Done")
}