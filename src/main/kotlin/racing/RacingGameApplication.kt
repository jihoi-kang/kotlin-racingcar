package racing

import racing.util.NumberGenerator
import racing.view.InputView
import racing.view.ResultView

class RacingGameApplication {

    fun run() {
        val params = InputView.getParams()
        val numberGenerator = NumberGenerator()
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
