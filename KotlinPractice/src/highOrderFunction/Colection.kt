package highOrderFunction

import java.lang.StringBuilder

// filter

//java
//list.stream().filter(e->e%2==0);

//map

//flatmap

fun main() {
    val list = intArrayOf(1, 2, 3, 4)



    list.flatMap { 0 until it }
        .joinToString().let(::println)

//聚合
    list.fold(StringBuffer()) { acc, i ->
        acc.append(i)
    }.toString().let(::println)

    list.reduce { acc, i ->
        acc * i
    }.toString().let (::println)

    println()
    list.zip(arrayOf("x", "y")) { a: Int, b: String ->
        a.toString() + b
    }.joinToString().let(::println)


    println()
    list.asSequence()
        .filter {
            println("filter:$it")
            it % 2 == 0
        }.map {
            println("map:$it")
            it * 2 + 1
        }.forEach {
            println("foreach:$it")
        }
}

