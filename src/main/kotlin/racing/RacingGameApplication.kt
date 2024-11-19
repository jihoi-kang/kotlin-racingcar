package racing

import racing.util.DefaultNumberGenerator
import racing.view.InputView
import racing.view.ResultView

class RacingGameApplication {

    private val numberGenerator = DefaultNumberGenerator

    fun run() {
        val params = InputView.getParams()
        val racingGame = RacingGame(params.cars, numberGenerator)

        ResultView.printStart()
        repeat(params.tryNumber) {
            racingGame.tryAdvance()
            ResultView.print(racingGame.cars)
        }

        ResultView.printWinner(racingGame.getWinners())
    }

}

fun main() {
    RacingGameApplication().run()
}
