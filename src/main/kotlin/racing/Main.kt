package racing

import racing.view.InputView

fun main() {
    val input = InputView.print()
    val racing = Racing()
    racing.start(input)
}
