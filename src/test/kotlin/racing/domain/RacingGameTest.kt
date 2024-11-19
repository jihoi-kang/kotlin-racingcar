package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racing.model.RacingCar

class RacingGameTest {

    @Test
    fun `숫자가 4이상이면 전진해야만 한다`() {
        // given
        val randomNumber = 4
        val racingGame = RacingGame(
            cars = listOf(RacingCar("jay")),
            tryChecker = TryChecker(1),
            winnerFinder = RacingGameWinnerFinder(),
            advanceChecker = AdvanceChecker(
                object : NumberGenerator {
                    override fun generate(max: Int): Int = randomNumber
                },
            )
        )

        // when
        racingGame.tryAdvance()

        // then
        assertThat(racingGame.cars[0].advancedNumber).isEqualTo(1)
    }

    @Test
    fun `숫자가 4미만이면 전진하지 않아야 한다`() {
        // given
        val randomNumber = 3
        val racingGame = RacingGame(
            cars = listOf(RacingCar("jay")),
            tryChecker = TryChecker(1),
            winnerFinder = RacingGameWinnerFinder(),
            advanceChecker = AdvanceChecker(
                object : NumberGenerator {
                    override fun generate(max: Int): Int = randomNumber
                },
            )
        )

        // when
        racingGame.tryAdvance()

        // then
        assertThat(racingGame.cars[0].advancedNumber).isEqualTo(0)
    }

    @Test
    fun `전진을 시도하면 시도횟수가 줄어들어야 한다`() {
        // given
        val racingGame = RacingGame(
            cars = listOf(RacingCar("jay")),
            tryChecker = TryChecker(1),
            winnerFinder = RacingGameWinnerFinder(),
            advanceChecker = AdvanceChecker(DefaultNumberGenerator),
        )

        // when
        racingGame.tryAdvance()

        // then
        assertThat(racingGame.hasTryNumber()).isFalse()
    }

}
