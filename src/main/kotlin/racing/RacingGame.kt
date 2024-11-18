package racing

import racing.model.RacingCar
import racing.util.NumberGenerator

class RacingGame(
    carNumber: Int,
    private val numberGenerator: NumberGenerator,
) {
    val cars = List(carNumber) { RacingCar(it) }

    fun tryAdvance() {
        cars.forEach { racingCar -> if (shouldAdvance()) racingCar.advance() }
    }

    private fun shouldAdvance() = numberGenerator.generate(MAX_RANDOM_ADVANCED) >= MOVE_ADVANCED_CONDITION

    companion object {
        private const val MAX_RANDOM_ADVANCED = 10
        private const val MOVE_ADVANCED_CONDITION = 4
    }

}
