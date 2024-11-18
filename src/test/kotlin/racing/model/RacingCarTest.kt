package racing.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingCarTest {

    @Test
    fun `0보 전진한 레이싱카가 전진하면 1이 되어야 한다`() {
        // given
        val racingCar = RacingCar("jay")

        // when
        racingCar.advance()

        // then
        assertThat(racingCar.advancedNumber).isEqualTo(1)
    }

}
