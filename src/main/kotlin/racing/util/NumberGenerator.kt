package racing.util

import kotlin.random.Random

class NumberGenerator(
    private val randomSupplier: (Int) -> Int = { Random.nextInt(it) },
) {
    fun generate(max: Int): Int = randomSupplier(max)
}
