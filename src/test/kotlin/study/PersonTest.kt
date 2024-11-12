package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "강지회", age = 31, nickname = "jay")
        assertThat(actual.name).isEqualTo("강지회")
        assertThat(actual.age).isEqualTo(31)
        assertThat(actual.nickname).isEqualTo("jay")
    }

    @Test
    fun `널 타입`() {
        val actual = Person(name = "강지회", age = 31, nickname = null)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person(name = "강지회", age = 31)
        assertThat(actual.nickname).isEqualTo("강지회")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "강지회", age = 31)
        val person2 = Person(name = "강지회", age = 31)
        assertThat(person1).isEqualTo(person2)
    }
}
