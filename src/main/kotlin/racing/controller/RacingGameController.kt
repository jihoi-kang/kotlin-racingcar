package racing.controller

import racing.domain.AdvanceChecker
import racing.domain.RacingGame
import racing.domain.RacingGameWinnerFinder
import racing.domain.TryChecker
import racing.domain.DefaultNumberGenerator
import racing.view.InputView
import racing.view.ResultView

class RacingGameController {

    fun run() {
        val params = InputView.getParams()
        val racingGame = RacingGame(
            cars = params.cars,
            tryChecker = TryChecker(params.tryNumber),
            winnerFinder = RacingGameWinnerFinder(),
            advanceChecker = AdvanceChecker(DefaultNumberGenerator)
        )

        ResultView.printStart()
        while (racingGame.hasTryNumber()) {
            racingGame.tryAdvance()
            ResultView.print(racingGame.cars)
        }

        ResultView.printWinner(racingGame.getWinner())
    }

}
