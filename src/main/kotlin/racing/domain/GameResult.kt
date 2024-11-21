package racing.domain

import racing.model.RacingCar

data class GameResult(
    val records: List<AdvanceRecord>,
    val winner: List<RacingCar>,
)
