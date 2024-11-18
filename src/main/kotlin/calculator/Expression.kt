package calculator

sealed class Expression {

    data class Operand(val number: Int) : Expression()

    sealed class Operator(val symbol: String) : Expression(), Calculable {
        data object Add : Operator("+") {
            override fun execute(first: Int, second: Int): Int = first + second
        }

        data object Subtract : Operator("-") {
            override fun execute(first: Int, second: Int): Int = first - second
        }

        data object Multiply : Operator("*") {
            override fun execute(first: Int, second: Int): Int = first * second
        }

        data object Divide : Operator("/") {
            override fun execute(first: Int, second: Int): Int =
                if (second == 0) throw IllegalStateException("0으로 나눌 수 없습니다")
                else first / second
        }

        companion object {
            private val operatorsBySymbol: Map<String, Operator> =
                listOf(Add, Subtract, Multiply, Divide).associateBy { it.symbol }

            fun of(symbol: String): Operator? = operatorsBySymbol[symbol]
        }
    }

}
