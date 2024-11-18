package racing.model

data class RacingCar(
    val name: String,
) {
    var advancedNumber: Int = 0
        private set

    fun advance() {
        this.advancedNumber++
    }
}
