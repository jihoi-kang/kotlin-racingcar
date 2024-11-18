package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racing.util.NumberGenerator

class RacingGameTest {

    @Test
    fun `숫자가 4이상이면 전진해야만 한다`() {
        // given
        val randomNumber = 4
        val racingGame = RacingGame(1, NumberGenerator { randomNumber })

        // when
        racingGame.tryAdvance()

        // then
        assertThat(racingGame.cars[0].advancedNumber).isEqualTo(1)
    }

    @Test
    fun `숫자가 4미만이면 전진하지 않아야 한다`() {
        // given
        val randomNumber = 3
        val racingGame = RacingGame(1, NumberGenerator { randomNumber })

        // when
        racingGame.tryAdvance()

        // then
        assertThat(racingGame.cars[0].advancedNumber).isEqualTo(0)
    }

}
