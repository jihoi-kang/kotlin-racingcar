package calculator

sealed class Expression {
    data class Operand(val number: Int) : Expression()
    sealed class Operator : Expression() {
        data object Add : Operator()
        data object Subtract : Operator()
        data object Multiply : Operator()
        data object Divide : Operator()
    }
}
