package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racing.model.RacingCar
import racing.util.DefaultNumberGenerator
import racing.util.NumberGenerator

class RacingGameTest {

    @Test
    fun `숫자가 4이상이면 전진해야만 한다`() {
        // given
        val randomNumber = 4
        val racingGame = RacingGame(listOf(RacingCar("jay")), object : NumberGenerator {
            override fun generate(max: Int): Int = randomNumber
        })

        // when
        racingGame.tryAdvance()

        // then
        assertThat(racingGame.cars[0].advancedNumber).isEqualTo(1)
    }

    @Test
    fun `숫자가 4미만이면 전진하지 않아야 한다`() {
        // given
        val randomNumber = 3
        val racingGame = RacingGame(listOf(RacingCar("jay")), object : NumberGenerator {
            override fun generate(max: Int): Int = randomNumber
        })

        // when
        racingGame.tryAdvance()

        // then
        assertThat(racingGame.cars[0].advancedNumber).isEqualTo(0)
    }

    @Test
    fun `우승자는 한명 이상일 수 있다`() {
        // given
        val cars = listOf(
            RacingCar(name = "pobi", _advancedNumber = 5),
            RacingCar(name = "crong", _advancedNumber = 5),
            RacingCar(name = "honux", _advancedNumber = 3),
        )
        val racingGame = RacingGame(cars, DefaultNumberGenerator)

        // when
        val winners = racingGame.getWinners()

        // then
        assertThat(winners.size).isEqualTo(2)
    }

}
