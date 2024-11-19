package racing.model

data class RacingCar(
    val name: String,
    private val _advancedNumber: Int = 0,
) {
    var advancedNumber: Int = _advancedNumber
        private set

    fun advance() {
        this.advancedNumber++
    }
}
