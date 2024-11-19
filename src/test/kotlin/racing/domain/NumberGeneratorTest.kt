package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NumberGeneratorTest {

    @Test
    fun `반환값을 지정할 수 있다`() {
        // given
        val generator = object : NumberGenerator {
            override fun generate(max: Int): Int = 4
        }

        // when
        val result = generator.generate(10)

        // then
        assertThat(result).isEqualTo(4)
    }

}
