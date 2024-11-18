package racing

import racing.util.NumberGenerator
import racing.view.InputView
import racing.view.ResultView
import kotlin.random.Random

class RacingGameApplication {

    private val numberGenerator = object : NumberGenerator {
        override fun generate(max: Int): Int = Random.nextInt(max)
    }

    fun run() {
        val params = InputView.getParams()
        val racingGame = RacingGame(params.cars, numberGenerator)

        ResultView.printStart()
        repeat(params.tryNumber) {
            racingGame.tryAdvance()
            ResultView.print(racingGame.cars)
        }
    }

}

fun main() {
    RacingGameApplication().run()
}
