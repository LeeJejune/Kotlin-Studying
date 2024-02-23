package org.jjlee.kotlin.thread

import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val job: Job = launch {
        delay(100L) // 1초간 대기
    }
    job.cancelAndJoin() // 코루틴 취소 요청 + 취소가 완료될 때까지 대기
    printJobState(job) // Job 상태 출력
}

fun printJobState(job: Job) {
    println(
        "Job State\n" +
                "isActive >> ${job.isActive}\n" +
                "isCancelled >> ${job.isCancelled}\n" +
                "isCompleted >> ${job.isCompleted} "
    )
}