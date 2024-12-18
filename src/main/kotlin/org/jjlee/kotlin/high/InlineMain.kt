package org.jjlee.kotlin.high

/**
 * 고차함수 예시
 * 함수(람다)를 함수의 호출 인자로 전달하거나, 반환값으로 활용할 수도 있다.
 * 람다를 사용하게 되면 부가적인 메모리 할당으로 인해 메모리 효율이 안 좋아지고, 함수 호출로 인한 런타임 오버헤드 발생
 * 아래 someMethod 함수 컴파일 시 람다로 구현된 함수는 새로운 객체를 생성하여 넘겨줌
 * 무의미하게 객체를 생성하여 메모리를 차지하고, 내부적으로 연쇄적인 함수 호출 => 오버헤드 발생
 */
fun someMethod(a: Int, doSomething: () -> Unit): Int {
    doSomething()
    return 2 * a
}

/**
 * inline 키워드를 사용하면 람다를 사용하는 함수를 호출하는 곳에 람다의 내용을 복사해 넣음
 * code 복사 개념 -> 인자로 받은 함수가 다른 함수로 전달 되거나 참조될 순 없다.
 */
inline fun someMethodWithInLine(a: Int, doSomething: () -> Unit): Int {
    doSomething()
    return 2 * a
}

/**
 * 일부는 다른 함수로 넘겨줘야할 때와 같이, 모든 인자를 inline 처리해서는 안 될 때 사용하는 키워드가 바로 noinline
 * inline 함수 내에서만 사용 가능
 */
inline fun firstMethod(a: Int, func1: () -> Unit, noinline func2: () -> Unit) {
    func1()
    someMethod(10, func2)
}

/**
 * 많은 코드를 담고 있는 람다를 inline 처리하면 바이트코드의 양이 훨씬 많아지게됨.
 * 적절히 코드를 구성하여 inline 처리할지 말지 결정해야함
 */

fun main() {
    val result = someMethod(10) {
        println("예시")
    }
    println(result)
}

