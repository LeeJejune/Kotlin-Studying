package org.jjlee.kotlin.high

fun doSomethingElse(func: () -> Unit) {
    println("Doing something else")
    func()
}

/**
 * Java 코드로 변환 시 doSomethingElse 함수의 파라미터는 Function 객체를 새롭게 생성.
 * doSomethingElse를 inline function으로 변경하면 어느정도 오버헤드를 줄일 수 있음.
 */
fun doSomething1() {
    println("Before lambda")

    doSomethingElse {
        println("Inside lambda")
    }

    println("After lambda")
}

/**
 * Java 코르도 변환 시 new Funtion(greetings) 객체를 생성할 때 로컬 변수까지 추가 되 메모리 사용량이 증가.
 * 이는 inline을 이용해서 없앨 수는 없음.
 */
fun doSomething2() {
    val greetings = "Hello"

    doSomethingElse {
        println("$greetings from lambda")
    }
}

/**
 * Reified와 함께 inline을 사용하면 타입 파라미터를 사용할 수 있음.
 * T 타입의 파라미터를 인식하고, 런타임에서 접근할 수 있도록 해줌.
 */
// runtime에서도 타입을 알 수 있게 Class<T> 넘김
//fun <T> doSomething(someValue: T, Class<T> type) {
//    // T의 타입을 파라미터를 통해 알기에 OK
//    println("Doing something with value: $someValue")
//    // T::class 가 어떤 class인지 몰라서 Error
//    println("Doing something with type: ${T::class.simpleName}")
//}

//reified로 런타임시 T의 타입을 유추 할 수있게됨
inline fun <reified T> doSomething(someValue: T) {
    // OK
    println("Doing something with value: $someValue")
    // T::class 가 reified로 인해 타입을 알 수 있게되어 OK
    println("Doing something with type: ${T::class.simpleName}")
}

/**
 * 다만, 이 또한 만능은 아니고, private 함수나 local 함수에는 사용할 수 없음.
 * 이 또한, 코드의 영향을 많이 받기 떄문에 적절한 상황에서 사용해야 함.
 */
fun main() {
    doSomething("Hi")
}