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
            advanceChecker = AdvanceCheckerImpl(DefaultNumberGenerator)
        )

        // when
        racingGame.play()

        // then
        assertThat(racingGame.recorder.records.size).isEqualTo(tryNumber)
    }

    @Test
    fun `전진 확인자가 True이면 전진해야만 한다`() {
        // given
        val racingGame = RacingGame(
            cars = listOf(RacingCar("jay")),
            recorder = AdvanceRecorder(),
            tryChecker = TryChecker(1),
            winnerFinder = RacingGameWinnerFinder(),
            advanceChecker = object : AdvanceChecker {
                override fun shouldAdvance(): Boolean = true
            }
        )

        // when
        racingGame.play()

        // then
        assertThat(racingGame.cars[0].advancedNumber).isEqualTo(1)
    }

    @Test
    fun `전진 확인자가 False이면 전진하지 않아야 한다`() {
        // given
        val racingGame = RacingGame(
            cars = listOf(RacingCar("jay")),
            recorder = AdvanceRecorder(),
            tryChecker = TryChecker(1),
            winnerFinder = RacingGameWinnerFinder(),
            advanceChecker = object : AdvanceChecker {
                override fun shouldAdvance(): Boolean = false
            }
        )

        // when
        racingGame.play()

        // then
        assertThat(racingGame.cars[0].advancedNumber).isEqualTo(0)
    }

}
