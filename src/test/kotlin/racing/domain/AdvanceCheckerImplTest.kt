package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AdvanceCheckerImplTest {

    @Test
    fun `랜덤수가 4이상이면 전진할 수 있다`() {
        // given
        val advanceChecker = AdvanceCheckerImpl(object : NumberGenerator {
            override fun generate(max: Int): Int = 4
        })

        // when
        val result = advanceChecker.shouldAdvance()

        // then
        assertThat(result).isTrue()
    }

    @Test
    fun `랜덤수가 3이면 전진할 수 없다`() {
        // given
        val advanceChecker = AdvanceCheckerImpl(object : NumberGenerator {
            override fun generate(max: Int): Int = 3
        })

        // when
        val result = advanceChecker.shouldAdvance()

        // then
        assertThat(result).isFalse()
    }

}
