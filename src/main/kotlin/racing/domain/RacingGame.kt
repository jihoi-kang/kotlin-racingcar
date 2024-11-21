package racing.domain

import racing.model.RacingCar

class RacingGame(
    private val cars: List<RacingCar>,
    private val recorder: AdvanceRecorder,
    private val tryChecker: TryChecker,
    private val winnerFinder: RacingGameWinnerFinder,
    private val advanceChecker: AdvanceChecker,
) {

    fun play(): GameResult {
        while (tryChecker.hasTryNumber()) {
            tryAdvance()
            recorder.note(cars)
        }

        return GameResult(
            records = recorder.records(),
            winner = winnerFinder.find(cars),
        )
    }

    private fun tryAdvance() {
        cars.forEach { racingCar -> racingCar.tryAdvance() }
        tryChecker.tried()
    }

    private fun RacingCar.tryAdvance() {
        if (advanceChecker.shouldAdvance()) this.advance()
    }

}
