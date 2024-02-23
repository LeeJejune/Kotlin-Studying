package org.jjlee.kotlin.thread

import kotlinx.coroutines.launch
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.runBlocking

//fun main() = runBlocking<Unit>(context = CoroutineName("Main")) {
//    println("[${Thread.currentThread().name}] 실행")
//    launch(context = CoroutineName("Coroutine1")) {
//        println("[${Thread.currentThread().name}] 실행")
//    }
//    launch(context = CoroutineName("Coroutine2")) {
//        println("[${Thread.currentThread().name}] 실행")
//    }
//}

fun main() = runBlocking<Unit> {
    val multiThreadDispatcher = newFixedThreadPoolContext(
        nThreads = 2,
        name = "MultiThread"
    )
    launch(multiThreadDispatcher) { // 부모 Coroutine
        println("[${Thread.currentThread().name}] 부모 코루틴 실행")
        launch { // 자식 코루틴 실행
            println("[${Thread.currentThread().name}] 자식 코루틴 실행")
        }
        launch { // 자식 코루틴 실행
            println("[${Thread.currentThread().name}] 자식 코루틴 실행")
        }
    }
}