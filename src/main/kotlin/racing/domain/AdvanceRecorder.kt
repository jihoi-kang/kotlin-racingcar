package racing.domain

import racing.model.RacingCar

class AdvanceRecorder(
    private val records: MutableList<AdvanceRecord> = mutableListOf(),
) {

    fun records(): List<AdvanceRecord> = records.toList()

    fun note(cars: List<RacingCar>) {
        records.add(AdvanceRecord(cars = copy(cars)))
    }

    private fun copy(cars: List<RacingCar>) =
        cars.map { it.copy(_advancedNumber = it.advancedNumber) }

}
