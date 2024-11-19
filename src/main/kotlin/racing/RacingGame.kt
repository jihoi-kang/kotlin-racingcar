package racing

import racing.model.RacingCar
import racing.util.NumberGenerator

class RacingGame(
    val cars: List<RacingCar>,
    private val numberGenerator: NumberGenerator,
) {

    fun getWinners(): List<RacingCar> =
        cars.filter { it.advancedNumber == cars.maxOf { it.advancedNumber } }

    fun tryAdvance() {
        cars.forEach { racingCar -> if (shouldAdvance()) racingCar.advance() }
    }

    private fun shouldAdvance() = numberGenerator.generate(MAX_RANDOM_ADVANCED) >= MOVE_ADVANCED_CONDITION

    companion object {
        private const val MAX_RANDOM_ADVANCED = 10
        private const val MOVE_ADVANCED_CONDITION = 4
    }

}
