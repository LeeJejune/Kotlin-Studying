package org.jjlee.kotlin.thread

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    val longJob: Job = launch(Dispatchers.Default) {
        repeat(10) { repeatTime ->
            delay(500L) // 1000밀리초 대기
            println("[${getElapsedTime(startTime)}] 반복횟수 $repeatTime")
        }
    }
    delay(3500L) // 3500밀리초(3.5초)간 대기 -> 3500밀리초가 지나면 코루틴 취소
    longJob.cancel() // 코루틴 취소
}
fun getElapsedTime(startTime: Long): String = "지난 시간: ${System.currentTimeMillis() - startTime}ms"