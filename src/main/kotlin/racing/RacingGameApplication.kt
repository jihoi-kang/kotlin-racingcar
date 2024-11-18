package racing

import racing.util.NumberGenerator
import racing.view.InputView
import racing.view.ResultView
import kotlin.random.Random

class RacingGameApplication {

    fun run() {
        val params = InputView.getParams()
        val numberGenerator = object : NumberGenerator {
            override fun generate(max: Int): Int = Random.nextInt(max)
        }
        val racingGame = RacingGame(params.carNumber, numberGenerator)

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
