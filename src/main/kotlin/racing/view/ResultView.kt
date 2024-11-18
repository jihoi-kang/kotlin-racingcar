package racing.view

import racing.model.RacingCar

object ResultView {
    fun printStart() {
        println("실행 결과")
    }

    fun print(cars: List<RacingCar>) {
        cars.forEach { println(it.advancedNumber.toHyphenString()) }
        println()
    }

    private fun Int.toHyphenString(): String = "-".repeat(this)
}
