package racing.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingGameParamsTest {

    @Test
    fun `차 이름들을 입력하면 차 객체(cars) 사이즈는 동일해야 한다`() {
        // given
        val carNames = listOf("pobi", "crong", "honux")

        // when
        val params = RacingGameParams(carNames, 1)

        // then
        assertThat(params.cars.size).isEqualTo(carNames.size)
    }

    @Test
    fun `차 이름들을 입력하면 각 index에 맞게 차 객체(cars) 이름은 동일해야 한다`() {
        // given
        val carName = "pobi"
        val carNames = listOf(carName, "AAA", "BBB")

        // when
        val params = RacingGameParams(carNames, 1)

        // then
        assertThat(params.cars[0].name).isEqualTo(carName)
    }

}
