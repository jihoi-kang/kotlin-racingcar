package racing.view

import racing.domain.AdvanceRecord
import racing.model.RacingCar

object ResultView {
    fun printResult(records: List<AdvanceRecord>) {
        println("실행 결과")
        printRecords(records)
        println()
    }

    private fun printRecords(records: List<AdvanceRecord>) {
        records.forEach {
            printCars(it.cars)
        }
    }

    private fun printCars(cars: List<RacingCar>) {
        cars.forEach {
            println("${it.name}: ${it.advancedNumber.toHyphenString()}")
        }
        println()
    }

    fun printWinner(winnerCars: List<RacingCar>) {
        println("${winnerCars.joinToString(", ") { it.name }}가 최종 우승했습니다.")
    }

    private fun Int.toHyphenString(): String = "-".repeat(this)

}
