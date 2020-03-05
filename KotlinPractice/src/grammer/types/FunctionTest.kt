package grammer.types

fun main(args: Array<String>): Unit {
    val f = Fun()
    val f1 = f.foo(1)
    println(f1)
    println("----------------------------------")
    val f2: (Int) -> String = f::foo
    println(f2(2))
    println("----------------------------------")
    val f3: (Fun, Int) -> String = Fun::foo
    println(f3(f, 3))
}

fun m(p0: String, p1: String): String {
    return "${p0} ${p1}！"
}

class Fun {
    fun foo(p0: Int): String {
        return "The number is $p0"
    }
}