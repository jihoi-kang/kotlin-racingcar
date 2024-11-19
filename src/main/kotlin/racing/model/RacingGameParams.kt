package racing.model

data class RacingGameParams(
    val carNames: List<String>,
    val tryNumber: Int,
) {
    val cars: List<RacingCar> = carNames.map { RacingCar(name = it) }
}
