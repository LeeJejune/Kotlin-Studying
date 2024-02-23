package org.jjlee.kotlin.thread

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    launch(CoroutineName("Coroutine1")) {
        val coroutine1Job = this.coroutineContext[Job]
        val newJob = Job(coroutine1Job)
        println("[${Thread.currentThread().name} + ${coroutineContext.job}] 코루틴 실행")

        launch(CoroutineName("Coroutine2") + newJob) {
            delay(1000L)
            println("[${Thread.currentThread().name} + ${coroutineContext.job}] 코루틴 실행")
        }
        newJob.complete()
    }
}