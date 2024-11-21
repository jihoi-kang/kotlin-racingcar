package racing.domain

import racing.model.RacingCar

class AdvanceRecorder(
    records: List<AdvanceRecord> = listOf(),
) {
    var records: List<AdvanceRecord> = records
        private set

    fun note(cars: List<RacingCar>) {
        records = records.toMutableList().apply {
            add(AdvanceRecord(cars = copy(cars)))
        }
    }

    private fun copy(cars: List<RacingCar>) =
        cars.map { it.copy(_advancedNumber = it.advancedNumber) }

}
