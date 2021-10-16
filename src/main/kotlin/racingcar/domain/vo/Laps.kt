package racingcar.domain.vo

private const val FIRST_ROUND = 1

@JvmInline
value class Laps private constructor(val values: List<Lap>) {
    init {
        require(values.isNotEmpty()) { "한 바퀴 이상 경주해야 합니다." }
    }

    companion object {
        fun of(rounds: String?): Laps {
            require(!rounds.isNullOrBlank()) {}
            require(rounds.toIntOrNull() != null) {}
            return of(rounds.toInt())
        }
        fun of(rounds: Int): Laps = Laps((FIRST_ROUND..rounds).map { Lap.of(it) })
        fun of(laps: Set<Lap>): Laps {
            return Laps(laps.sortedBy { it.round })
        }
    }
}
