package org.jjlee.kotlin.example

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {

    /*
         first example
     */
//    simple().forEach { value -> println(value) }

    /*
        second example
    */
    launch {
        for (k in 1..3) {
            println("I'm not blocked $k")
            delay(100)
        }
    }
    // Collect the flow
    simple().collect { value -> println(value) }

}

//suspend fun simple(): List<Int> {
//    delay(1000)
//    val list = listOf(1,2,3,)
//    return list.shuffled()
//}

fun simple(): Flow<Int> = flow { // flow builder
    for (i in 1..3) {
        delay(1000)
        emit(i)
    }
}
