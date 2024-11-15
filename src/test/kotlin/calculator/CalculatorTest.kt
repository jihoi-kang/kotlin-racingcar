package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class CalculatorTest {
    @Test
    fun `덧셈 연산`() {
        val result = Calculator.calculate("2 + 3")
        assertThat(result).isEqualTo(5)
    }

    @Test
    fun `뺄셈 연산`() {
        val result = Calculator.calculate("2 - 3")
        assertThat(result).isEqualTo(-1)
    }

    @Test
    fun `곱셈 연산`() {
        val result = Calculator.calculate("2 * 3")
        assertThat(result).isEqualTo(6)
    }

    @Test
    fun `나눗셈 연산`() {
        val result = Calculator.calculate("2 / 3")
        assertThat(result).isEqualTo(0)
    }

    @Test
    fun `0으로 나누면 에러를 발생해야 한다`() {
        // given
        val input = "2 / 0"

        // when * then
        assertThatThrownBy { Calculator.calculate(input) }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessageContaining("0으로 나눌 수 없습니다")
    }

    @Test
    fun `입력값이 null이면 에러를 발생해야 한다`() {
        // given
        val input = null

        // when * then
        assertThatThrownBy { Calculator.calculate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("입력값이 비어있을 수 없습니다")
    }

    @Test
    fun `입력값이 빈 공백 문자이면 에러를 발생해야 한다`() {
        // given
        val input = " "

        // when * then
        assertThatThrownBy { Calculator.calculate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("입력값이 비어있을 수 없습니다")
    }

    @Test
    fun `사칙 연산 기호가 아닌 경우 에러를 발생해야 한다`() {
        // given
        val input = "1 abc 2"

        // when * then
        assertThatThrownBy { Calculator.calculate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("잘못된 형식의 사칙연산 입니다")
    }

    @Test
    fun `사칙 연산`() {
        // given
        val input = "2 + 3 * 4 / 2"

        // when
        val result = Calculator.calculate(input)

        // then
        assertThat(result).isEqualTo(10)
    }

    @Test
    fun `사칙 연산 중 연산자가 두번 연속으로 중복되어 나오면 에러를 발생해야 한다`() {
        // given
        val input = "2 + / 3"

        // when & then
        assertThatThrownBy { Calculator.calculate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("잘못된 형식의 사칙연산 입니다")
    }

    @Test
    fun `사칙 연산 중 피연산자가 두번 연속으로 중복되어 나오면 에러를 발생해야 한다`() {
        // given
        val input = "2 + 3 5 + 3"

        // when & then
        assertThatThrownBy { Calculator.calculate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("잘못된 형식의 사칙연산 입니다")
    }

    @Test
    fun `사칙 연산 중 연산자가 먼저 나오면 에러를 발생해야 한다`() {
        // given
        val input = "+ 3 + 3"

        // when & then
        assertThatThrownBy { Calculator.calculate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("잘못된 형식의 사칙연산 입니다")
    }

    @Test
    fun `사칙 연산 중 연산자가 가장 마지막에 나오면 에러를 발생해야 한다`() {
        // given
        val input = "3 + 3 -"

        // when & then
        assertThatThrownBy { Calculator.calculate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("잘못된 형식의 사칙연산 입니다")
    }
}
