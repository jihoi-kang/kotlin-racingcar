package racing.model

data class RacingCar(
    val id: Int, // start from 0
) {
    var advancedNumber: Int = 0
        private set

    fun advance() {
        this.advancedNumber++
    }
}
