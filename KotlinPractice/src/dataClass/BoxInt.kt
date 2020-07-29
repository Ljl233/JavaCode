package dataClass
//不能继承父类，不能被继承

inline class BoxInt(val value: Int) : Comparable<Int> {
    //1. 必须主构造器
    //2   public
    // val

    operator fun inc(): BoxInt {
        return BoxInt(value + 1)
    }

    override fun compareTo(other: Int): Int = value.compareTo(other)


}

fun main() {
    UInt
    var boxInt = BoxInt(5)
    val newValue = boxInt.value * 2
    println(newValue)
    boxInt++
    println(boxInt)
}

inline class State(val ordinal: Int) {
    companion object {
        val Idle = State(0)
        val Busy = State(1)
    }

    fun values() = arrayOf(Idle, Busy)
}

inline class RouteTypeInline(val value: Int)

object RouteTypes {
    val WALK = RouteTypeInline(0)
    val BUS = RouteTypeInline(1)
    val CAR = RouteTypeInline(2)
}