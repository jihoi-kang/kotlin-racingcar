package racing

import racing.model.RacingCar
import racing.model.RacingGameParams
import racing.view.InputView
import racing.view.ResultView
import kotlin.random.Random

class RacingGame {

    fun start(params: RacingGameParams) {
        val cars = List(params.carNumber) { RacingCar(it) }
        ResultView.printStart()

        repeat(params.tryNumber) {
            tryAdvance(cars)
            ResultView.print(cars)
        }
    }

    private fun tryAdvance(cars: List<RacingCar>) {
        cars.forEach { racingCar -> if (shouldAdvance()) racingCar.advance() }
    }

    private fun shouldAdvance() = Random.nextInt(MAX_RANDOM_ADVANCED) >= MOVE_ADVANCED_CONDITION

    companion object {
        private const val MAX_RANDOM_ADVANCED = 10
        private const val MOVE_ADVANCED_CONDITION = 4
    }

}

fun main() {
    val params = InputView.getParams()
    val racingGame = RacingGame()
    racingGame.start(params)
}
