package calculator

sealed class Expression {
    data class Operand(val number: Int) : Expression()
    sealed class Operator : Expression() {
        data object Add : Operator()
        data object Subtract : Operator()
        data object Multiply : Operator()
        data object Divide : Operator()

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
