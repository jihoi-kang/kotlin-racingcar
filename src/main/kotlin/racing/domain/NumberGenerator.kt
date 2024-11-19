package racing.domain

import kotlin.random.Random

interface NumberGenerator {
    fun generate(max: Int): Int
}

val DefaultNumberGenerator = object : NumberGenerator {
    override fun generate(max: Int): Int = Random.nextInt(max)
}
