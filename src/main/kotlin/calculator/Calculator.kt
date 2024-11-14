package calculator

object Calculator {
    fun calculate(input: String?): Int {
        require(!input.isNullOrBlank()) { "입력값이 비어있을 수 없습니다" }
        return input.parse().calculate()
    }

    private fun String.parse(): List<Expression> {
        val expressions = mutableListOf<Expression>()
        var lastExpression: Expression? = null

        this.split(" ").forEach {
            val expression = Expression.Operator.of(it) ?: runCatching<Expression.Operand> {
                Expression.Operand(it.toInt())
            }.getOrElse {
                throw IllegalArgumentException("연산자 및 피연산자 외의 값을 입력할 수 없습니다")
            }

            validate(expressions, lastExpression, expression)

            lastExpression = expression
            expressions.add(expression)
        }

        return expressions
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

    private fun validate(
        expressions: MutableList<Expression>,
        lastExpression: Expression?,
        currentExpression: Expression,
    ) {
        validateEnterOperatorAtBeginning(expressions, currentExpression)
        validateDuplicateExpression(lastExpression, currentExpression)
    }

    private fun validateEnterOperatorAtBeginning(
        expressions: MutableList<Expression>,
        currentExpression: Expression,
    ) {
        if (expressions.size == 0 && currentExpression is Expression.Operator) {
            throw IllegalArgumentException("피연산자를 먼저 입력해주세요")
        }
    }

    private fun validateDuplicateExpression(lastExpression: Expression?, currentExpression: Expression) {
        // 연산자가 두 번 연속으로 나오는 경우 검사
        if (lastExpression is Expression.Operator && currentExpression is Expression.Operator) {
            throw IllegalArgumentException("연산자 혹은 피연산자가 연속되어 중복으로 값을 입력할 수 없습니다")
        }
        // 피연산자가 두 번 연속으로 나오는 경우 검사
        if (lastExpression is Expression.Operand && currentExpression is Expression.Operand) {
            throw IllegalArgumentException("연산자 혹은 피연산자가 연속되어 중복으로 값을 입력할 수 없습니다")
        }
    }
}
