package racing.domain

class TryChecker(
    private var remainTryNumber: Int,
) {

    fun hasTryNumber() = remainTryNumber > 0

    fun tried() {
        if (remainTryNumber <= 0) {
            throw IllegalStateException("남은 시도 횟수가 존재하지 않습니다")
        }

        remainTryNumber -= 1
    }

}
