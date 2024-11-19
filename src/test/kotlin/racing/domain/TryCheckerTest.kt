package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class TryCheckerTest {

    @Test
    fun `시도 횟수가 1이상이면 hasTryNumber()는 true를 반환해야 한다`() {
        // given
        val tryChecker = TryChecker(1)

        // when
        val result = tryChecker.hasTryNumber()

        // then
        assertThat(result).isTrue()
    }


    @Test
    fun `시도 횟수가 0이면 hasTryNumber()는 false를 반환해야 한다`() {
        // given
        val tryChecker = TryChecker(0)

        // when
        val result = tryChecker.hasTryNumber()

        // then
        assertThat(result).isFalse()
    }

    @Test
    fun `1회 시도 횟수가 남은 상태에서 시도하면 hasTryNumber는 false를 반환해야 한다`() {
        // given
        val tryChecker = TryChecker(1)
        tryChecker.tried()

        // when
        val result = tryChecker.hasTryNumber()

        // then
        assertThat(result).isFalse()
    }

    @Test
    fun `0회 시도 횟수가 남은 상태에서 시도하면 에러가 발생해야 한다`() {
        // given
        val tryChecker = TryChecker(0)

        // when & then
        assertThatThrownBy { tryChecker.tried() }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessageContaining("남은 시도 횟수가 존재하지 않습니다")
    }

}
