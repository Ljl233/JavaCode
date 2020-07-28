package dataClass

enum class State(var id: Int) : Runnable {
    Idle(0), Busy(1) {
        override fun run() {
            println("run for busy")
        }
    };

    override fun run() {
        println("all state run this")
    }
}

enum class Color {
    White, Red, Green, Blue, Yellow, Black
}

val colorRange = Color.White..Color.Green
val color = Color.Black


fun State.next(): State {
    return State.values().let {
        val nextOrdinal = (ordinal + 1) % it.size
        it[nextOrdinal]
    }

    if (color in colorRange){

    }
}

fun main() {
    State.Idle.name
    var state = State.Busy

    val value = when (state) {
        State.Idle -> 0
        State.Busy -> 1
    }

    if (state <= State.Idle) {

    }
}