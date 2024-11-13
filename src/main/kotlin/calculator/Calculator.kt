package calculator

object Calculator {
    fun calculate(input: String?): Int {
        requireNotNull(input) { "입력값이 비어있을 수 없습니다" }
        require(input.isNotBlank()) { "입력값이 비어있을 수 없습니다" }
        return input.parse().calculate()
    }

    private fun String.parse(): List<Expression> = this.split(" ").map {
        when (it) {
            "+" -> Expression.Operator.Add
            "-" -> Expression.Operator.Subtract
            "*" -> Expression.Operator.Multiply
            "/" -> Expression.Operator.Divide
            else -> {
                try {
                    Expression.Operand(it.toInt())
                } catch (e: NumberFormatException) {
                    throw IllegalArgumentException("연산자 및 피연산자 외의 값을 입력할 수 없습니다")
                }
            }
        }
    }

    private fun List<Expression>.calculate(): Int {
        var result = 0
        var operator: Expression.Operator? = null
        this.forEach { expression ->
            when (expression) {
                is Expression.Operand -> {
                    result = when (operator) {
                        Expression.Operator.Add -> result + expression.number
                        Expression.Operator.Subtract -> result - expression.number
                        Expression.Operator.Multiply -> result * expression.number
                        Expression.Operator.Divide ->
                            if (expression.number == 0) throw IllegalStateException("0으로 나눌 수 없습니다")
                            else result / expression.number

                        null -> expression.number
                    }
                }

                is Expression.Operator -> operator = expression
            }
        }

        return result
    }
}
