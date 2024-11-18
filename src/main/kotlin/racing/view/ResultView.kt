package racing.view

import racing.model.RacingCar

object ResultView {
    fun printStart() {
        println("실행 결과")
    }

    fun print(cars: List<RacingCar>) {
        cars.forEach { println("${it.name}: ${it.advancedNumber.toHyphenString()}") }
        println()
    }

    fun printWinner(winnerCars: List<RacingCar>) {
        println("${winnerCars.joinToString(", ") { it.name }}가 최종 우승했습니다.")
    }

    private fun Int.toHyphenString(): String = "-".repeat(this)
}
