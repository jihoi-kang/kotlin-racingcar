package racing.domain

import racing.model.RacingCar

class RacingGame(
    val cars: List<RacingCar>,
    private val tryChecker: TryChecker,
    private val winnerFinder: RacingGameWinnerFinder,
    private val advanceChecker: AdvanceChecker,
) {

    fun getWinner(): List<RacingCar> = winnerFinder.find(cars)

    fun hasTryNumber() = tryChecker.hasTryNumber()

    fun tryAdvance() {
        cars.forEach { racingCar -> racingCar.tryAdvance() }
        tryChecker.tried()
    }

    private fun RacingCar.tryAdvance() {
        if (advanceChecker.shouldAdvance()) this.advance()
    }

}
