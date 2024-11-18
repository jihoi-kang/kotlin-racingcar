package racing.view

import racing.model.RacingGameParams

object InputView {
    private val validNamesRegex = "^([a-zA-Z0-9]+)(,[a-zA-Z0-9]+){0,4}\$".toRegex()

    fun getParams(): RacingGameParams = RacingGameParams(showAndGetCarNamesInput(), showAndGetTryNumberInput())

    private fun showAndGetCarNamesInput(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)")
        return readln()
            .also { validateNames(it) }
            .split(",")
            .map { it.trim() }
    }

    private fun showAndGetTryNumberInput(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readln().toInt()
    }

    private fun validateNames(input: String) = validNamesRegex.matches(input)

}
