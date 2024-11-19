package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racing.model.RacingCar

class RacingGameWinnerFinderTest {

    @Test
    fun `우승자는 한명 이상일 수 있다`() {
        // given
        val cars = listOf(
            RacingCar(name = "pobi", _advancedNumber = 5),
            RacingCar(name = "crong", _advancedNumber = 5),
            RacingCar(name = "honux", _advancedNumber = 3),
        )
        val winnerFinder = RacingGameWinnerFinder()

        // when
        val winners = winnerFinder.find(cars)

        // then
        assertThat(winners.size).isEqualTo(2)
    }

}
