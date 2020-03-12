package closure

fun a(): (Int) -> Int {
    val i = 1
    fun b(a: Int): Int {
        return i + a;
    }
    return ::b
}

fun main() {
    val res = a()
    println(res(1))
}
