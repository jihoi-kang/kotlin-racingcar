package calculator

sealed class Expression {

    data class Operand(val number: Int) : Expression()

    sealed class Operator : Expression(), Calculable {
        data object Add : Operator() {
            override fun execute(first: Int, second: Int): Int = first + second
        }

        data object Subtract : Operator() {
            override fun execute(first: Int, second: Int): Int = first - second
        }

        data object Multiply : Operator() {
            override fun execute(first: Int, second: Int): Int = first * second
        }

        data object Divide : Operator() {
            override fun execute(first: Int, second: Int): Int =
                if (second == 0) throw IllegalStateException("0으로 나눌 수 없습니다")
                else first / second
        }

        companion object {
            private const val ADD_OPERATOR_STR = "+"
            private const val SUBTRACT_OPERATOR_STR = "-"
            private const val MULTIPLY_OPERATOR_STR = "*"
            private const val DIVIDE_OPERATOR_STR = "/"

            fun of(operatorStr: String): Operator? = when (operatorStr) {
                ADD_OPERATOR_STR -> Add
                SUBTRACT_OPERATOR_STR -> Subtract
                MULTIPLY_OPERATOR_STR -> Multiply
                DIVIDE_OPERATOR_STR -> Divide
                else -> null
            }
        }
    }

}
