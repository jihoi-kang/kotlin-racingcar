package racing

fun main() {
    println("자동차 대수는 몇 대인가요?")
    val carNumber = readln().toInt()
    println("시도할 횟수는 몇 회인가요?")
    val tryNumber = readln().toInt()

    println("carNumber=${carNumber} tryNumber=${tryNumber}")
}
