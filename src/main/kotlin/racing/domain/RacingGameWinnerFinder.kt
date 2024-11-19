package racing.domain

import racing.model.RacingCar

class RacingGameWinnerFinder {

    fun find(cars: List<RacingCar>): List<RacingCar> {
        val maxAdvancedNumber = cars.maxOf { it.advancedNumber }
        return cars.filter { it.advancedNumber == maxAdvancedNumber }
    }

}
