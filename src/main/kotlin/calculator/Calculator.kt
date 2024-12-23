package calculator

object Calculator {

    private val validExpressionRegex = Regex("""^(\d+)(\s[+\-*/]\s\d+)*$""")

    fun calculate(input: String?): Int {
        require(!input.isNullOrBlank()) { "입력값이 비어있을 수 없습니다" }
        require(validExpressionRegex.matches(input)) { "잘못된 형식의 사칙연산 입니다" }
        return input.parse().calculate()
    }

    private fun String.parse(): List<Expression> = this.split(" ").map {
        Expression.Operator.of(it) ?: runCatching<Expression.Operand> {
            Expression.Operand(it.toInt())
        }.getOrElse {
            throw IllegalArgumentException("연산자 및 피연산자 외의 값을 입력할 수 없습니다")
        }
    }

    private fun List<Expression>.calculate(): Int {
        var result = 0
        var operator: Expression.Operator? = null
        this.forEach { expression ->
            when (expression) {
                is Expression.Operand -> result = operator?.execute(result, expression.number) ?: expression.number
                is Expression.Operator -> operator = expression
            }
        }

        return result
    }
}
