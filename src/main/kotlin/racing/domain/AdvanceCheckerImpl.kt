package racing.domain

class AdvanceCheckerImpl(
    private val numberGenerator: NumberGenerator,
) : AdvanceChecker {

    override fun shouldAdvance(): Boolean =
        numberGenerator.generate(MAX_RANDOM_ADVANCED) >= MOVE_ADVANCED_CONDITION

    companion object {
        private const val MAX_RANDOM_ADVANCED = 10
        private const val MOVE_ADVANCED_CONDITION = 4
    }
}
