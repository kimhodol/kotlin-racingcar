package racingcar.domain

data class Car(val name: String, val distance: Int = 0) {
    init {
        if (name.length > CAR_NAME_MAX_LENGTH) throw NameLengthOverflowException()
    }

    private fun move(): Car {
        return copy(name = name, distance = distance + 1)
    }

    fun moveIf(predicate: () -> Boolean): Car {
        return if (predicate()) {
            move()
        } else {
            this
        }
    }

    fun isIn(distance: Int): Boolean {
        return this.distance == distance
    }

    class NameLengthOverflowException : Exception("A car's name must be shorter.")

    companion object {
        private const val CAR_NAME_MAX_LENGTH = 5
    }
}