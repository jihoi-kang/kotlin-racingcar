package racing.domain

import racing.model.RacingCar

class RacingGame(
    val cars: List<RacingCar>,
    val recorder: AdvanceRecorder,
    private val tryChecker: TryChecker,
    private val winnerFinder: RacingGameWinnerFinder,
    private val advanceChecker: AdvanceChecker,
) {

    fun play() {
        while (tryChecker.hasTryNumber()) {
            tryAdvance()
            recorder.note(cars)
        }
    }

    fun getWinner(): List<RacingCar> = winnerFinder.find(cars)

    private fun tryAdvance() {
        cars.forEach { racingCar -> racingCar.tryAdvance() }
        tryChecker.tried()
    }

    private fun RacingCar.tryAdvance() {
        if (advanceChecker.shouldAdvance()) this.advance()
    }

}
