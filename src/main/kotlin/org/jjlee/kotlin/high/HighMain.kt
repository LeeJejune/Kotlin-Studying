package org.jjlee.kotlin.high

fun main() {
    // 람다 버전
    val sum : (Int, Int) -> Int = {x, y -> x+y}

    // Simple 버전 => 인텔리제이 코드 힌트로 파악 가능
    val sum1 = {x : Int, y : Int -> x + y}

    println(sum(1, 2))
    println(sum1(1, 2))

    // 람다의 경우
    println(calculator(1, 2, sum))

    // 일반 함수의 경우
    println(calculator(1, 2, ::sum))

    // 람다를 하나의 인자로 받는 함수
    println(square(2) { it * it })
}

fun sum(a : Int, b : Int) = a + b

// 인자가 하나인 경우도 사용 가능
fun square(a : Int, p: (Int) -> Int){
    println("square $a -> ${p(a)}")
}

/**
 * a와 b를 받아서 p함수를 처리하여 출력하는 고차 함수
 */
fun calculator(a : Int, b : Int, p: (Int, Int) -> Int){
    println("$a, $b -> ${p(a, b)}")
}