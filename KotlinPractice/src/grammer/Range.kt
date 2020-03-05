package grammer

fun main() {
    val intRange = 1..10 //[1,10]  type:IntRange ctrl + shift + P
    val charRange = 'a'..'z'  //离散值
    val longRange = 1L..10L

    val doubleRange = 1.0..2.0  //连续值

    println(longRange.joinToString())
    println(doubleRange.toString())

    val uIntRange = 1U..10U


    val intRangeExclusive = 1 until 10 //[1,10)

    val intRangeReverse = 10 downTo 1 //[10,9,8,...,1]

    val intRangeWithStep = 1..10 step 2 //步长

    if (3.0 in doubleRange)
        println("3 in double range")

    intRange.forEach {
        println(it)
    }

    val array = intArrayOf(1, 3, 5, 7)
    for (i in 0 until array.size)
        println(array[i])

    for (i in array.indices)
        println(array[i])
}