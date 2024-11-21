package racing.controller

import racing.domain.AdvanceCheckerImpl
import racing.domain.AdvanceRecorder
import racing.domain.DefaultNumberGenerator
import racing.domain.RacingGame
import racing.domain.RacingGameWinnerFinder
import racing.domain.TryChecker
import racing.view.InputView
import racing.view.ResultView

class RacingGameController {

    fun run() {
        val params = InputView.getParams()
        val racingGame = RacingGame(
            cars = params.cars,
            recorder = AdvanceRecorder(),
            tryChecker = TryChecker(params.tryNumber),
            winnerFinder = RacingGameWinnerFinder(),
            advanceChecker = AdvanceCheckerImpl(DefaultNumberGenerator)
        )

        val gameResult = racingGame.play()
        ResultView.printResult(gameResult.records)
        ResultView.printWinner(gameResult.winner)
    }

}
