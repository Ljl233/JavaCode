package dataClass

data class Bean(
    val name: String,
    val age: Int
)

fun main() {
    val (name, age) = Pair(1, 3)
    println("name=$name,age=$age")
}