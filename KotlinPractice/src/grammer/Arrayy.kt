package grammer

fun main() {
    var a = 1;
    a += 1;
    println(a)

    val c0 = intArrayOf(1, 2, 3, 4, 5)
    val c1 = IntArray(5) { 3 * it + 1 }
    println(c1.contentToString())

    val d = arrayOf("Hello", "World")
    d[1] = "Kotlin"
    println("${d[0]},${d[1]}")

    val w = floatArrayOf(1f, 2f, 3f)
    for (element in w) {
        println(element)
    }

    //shift + F6 rename
    w.forEach {
        println(it)
    }

    if (1f in w)
        println("1f in variable 'w'")


}

