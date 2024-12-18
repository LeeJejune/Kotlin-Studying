package org.jjlee.kotlin.high


/**
 * Extension(확장) 함수 상속이나 디자인 패턴 없이 클래스를 간단하게 확장할 수 있는 방법
 * 이는 정적 바인딩이 됨.
 * 예시로 이미 라이브러리에 있는 함수를 더 확장해서 쓰고 싶거나 추가적인 기능을 만들어서 사용하는 경우.
 */
fun main() {
    val kkotlin = KKotlin()
    kkotlin.hi()
    kkotlin.speak("안녕 나는 꼬틀린")

    // 간단한 예시
    "안녕 나는 꼬오틀린".speak()

    // 리스트 예시
    val numbers: List<Int> = listOf(1, 2, 3, 4, 5, 6)
    val filtered = numbers.getHigherThan(3).toString()
    println(filtered)
}

/**
 * KKotlin 클래스가 만약 라이브러리라 가정.
 * 메서드를 추가하기 어렵다.
 */
class KKotlin {
    private val name = "안녕?!"

    fun hi() {
        println(name)
    }
}

/**
 * 확장 함수는 마치 클래스 안에 메서드를 구현해서 사용하는 것처럼 만들어 주는 효과가 있는 거지
 * 실제로 클래스 안에 메서드가 만들어지진 않음
 * 1. 확장함수는 오버라이딩이 불가하다 (한마디로 클래스 안에 속하는 것이 아니기 떄문!)
 * 2. 확장함수는 오버로드가 가능하다. (매개변수 타입이 다르면 가능!)
 *  - 그렇지만 만약 멤버 메서드 이름과 확장 함수 이름이 같으면 클래스가 가지고 있는 메서드가 우선시됨.
 * 3. import를 하면 다른 곳에서도 확장함수를 사용 가능함.
 */
fun KKotlin.speak(sentence: String) {
    println(sentence)
    println(sentence)
}

fun String.speak() {
    println(this)
}

// list에서 num보다 큰 값들을 새로운 list로 리턴해주는 함수
fun List<Int>.getHigherThan(num: Int): List<Int> {
    val result = arrayListOf<Int>()
    forEach { item ->
        // 여기서 this는 리스트를 의미한다.
        if (item > num) {
            result.add(item)
        }
    }

    return result
}