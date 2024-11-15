package racing.view

import racing.model.RacingCar

object ResultView {
    fun print(cars: List<RacingCar>) {
        cars.forEach { racingCar ->
            println(racingCar.advancedNumber.toHyphen())
        }
    }

    private fun Int.toHyphen(): String = "-".repeat(this)
}
