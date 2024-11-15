package racing.view

import racing.model.Input

object InputView {
    fun getInput(): Input = Input(showAndGetCarNumberInput(), showAndGetTryNumberInput())

    private fun showAndGetCarNumberInput(): Int {
        println("자동차 대수는 몇 대인가요?")
        return readln().toInt()
    }

    private fun showAndGetTryNumberInput(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readln().toInt()
    }

}
