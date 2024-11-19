package racing

import racing.model.RacingCar
import racing.util.NumberGenerator

class RacingGame(
    val cars: List<RacingCar>,
    private val numberGenerator: NumberGenerator,
) {

    fun getWinners(): List<RacingCar> {
        val maxAdvancedNumber = cars.maxOf { it.advancedNumber }
        return cars.filter { it.advancedNumber == maxAdvancedNumber }
    }

    fun tryAdvance() {
        cars.forEach { racingCar -> if (shouldAdvance()) racingCar.advance() }
    }

    private fun shouldAdvance() = numberGenerator.generate(MAX_RANDOM_ADVANCED) >= MOVE_ADVANCED_CONDITION

    companion object {
        private const val MAX_RANDOM_ADVANCED = 10
        private const val MOVE_ADVANCED_CONDITION = 4
    }

}
