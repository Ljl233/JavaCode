package highOrderFunction

inline fun IntArray.forEach(action: (Int) -> Unit): Unit {
    for (element in this) action(element)
}

inline fun <R> IntArray.map(transform: (Int) -> R): List<R> {
    return mapTo(ArrayList<R>(size), transform);
}

//region +fs
//fun main() {
//    val intArray = intArrayOf(1, 2, 3, 4)
//
//    intArray.forEach(::println)
//
//    intArray.forEach {
//        println("Hello $it")
//    }
//    //#3
//    cost {
//        val fibonacciNext = fibonacci()
//        for (i in 0..10) {
//            println(fibonacciNext())
//        }
//    }
//}
//endregion

// #1
//calculate the time cost
fun cost(block: () -> Unit) {
    val start = System.currentTimeMillis()
    block()
    println(System.currentTimeMillis() - start)
}

// #2
fun fibonacci(): () -> Long {

    var first = 0L
    var second = 1L
    return {
        val next = first + second
        val current = first
        first = second
        second = next
        current
    }
}

/*
内联函数
 */

fun main(args: Array<String>) {

    val ints = intArrayOf(1, 2, 3, 4)
    ints.forEach { println("Hello,${it}") }
    /*inline fun IntArray.forEach(action: (Int) -> Unit): Unit {
        for (element in this) action(element)
    }*/

    for (element in ints) {
        println("Hello,${element}")
    }

    ints.forEach {
        if (it==3) return@forEach //continue
        println("Hello $it")
    }

    nonLocalReturn {
        return
        //从main函数返回
    }

}

//non-Local return
inline fun nonLocalReturn(block: () -> Unit){
    block()
}
// croossinline 禁止nonlocalreturn
// noinline 禁止函数被内联
inline fun Runnable(crossinline block: () -> Unit):Runnable{
    return object : Runnable{
        override fun run() {
            block()
        }

    }
}