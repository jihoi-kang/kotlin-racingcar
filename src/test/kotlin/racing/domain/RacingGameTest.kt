package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racing.model.RacingCar

class RacingGameTest {

    @Test
    fun `플레이가 끝나면 기록지(recorder)에 시도 횟수 만큼 쌓여야 한다`() {
        // given
        val tryNumber = 5
        val racingGame = RacingGame(
            cars = listOf(RacingCar("jay")),
            recorder = AdvanceRecorder(),
            tryChecker = TryChecker(tryNumber),
            winnerFinder = RacingGameWinnerFinder(),
            advanceChecker = AdvanceChecker(DefaultNumberGenerator)
        )

        // when
        racingGame.play()

        // then
        assertThat(racingGame.recorder.records.size).isEqualTo(tryNumber)
    }

    @Test
    fun `숫자가 4이상이면 전진해야만 한다`() {
        // given
        val randomNumber = 4
        val racingGame = RacingGame(
            cars = listOf(RacingCar("jay")),
            recorder = AdvanceRecorder(),
            tryChecker = TryChecker(1),
            winnerFinder = RacingGameWinnerFinder(),
            advanceChecker = AdvanceChecker(
                object : NumberGenerator {
                    override fun generate(max: Int): Int = randomNumber
                },
            )
        )

        // when
        racingGame.play()

        // then
        assertThat(racingGame.cars[0].advancedNumber).isEqualTo(1)
    }

    @Test
    fun `숫자가 4미만이면 전진하지 않아야 한다`() {
        // given
        val randomNumber = 3
        val racingGame = RacingGame(
            cars = listOf(RacingCar("jay")),
            recorder = AdvanceRecorder(),
            tryChecker = TryChecker(1),
            winnerFinder = RacingGameWinnerFinder(),
            advanceChecker = AdvanceChecker(
                object : NumberGenerator {
                    override fun generate(max: Int): Int = randomNumber
                },
            )
        )

        // when
        racingGame.play()

        // then
        assertThat(racingGame.cars[0].advancedNumber).isEqualTo(0)
    }

}
