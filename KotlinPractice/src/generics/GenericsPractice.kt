package generics

import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

class Box<T>(t: T) {
    var value = t;
    val box = Box("String")
    fun main() {
        box.value
//        var stringList: List<String> = ArrayList<String>()
//        var objectList: List<Any> = ArrayList<String>()

    }

}

sealed class List<T> {
    object Nil : List<Nothing>() {
        override fun toString(): String {
            return "Nil"
        }
    }

    data class Cons<T>(val head: T, val tail: List<T>) : List<T>() {
        override fun toString(): String {
            return "$head,$tail"
        }
    }
}

// 一个约束
fun <T : Comparable<T>> maxOf(a: T, b: T): T {
    return if (a > b) a else b
}

// 多个约束
fun <T, R> callMax(a: T, b: T): R
        where T : Comparable<T>, T : () -> R, R : Number {
    return if (a > b) a() else b()
}

interface Book

interface EduBook : Book

class BookStore<out T : Book> {
    fun getBook(): T {
        TODO()
    }
}

// 协变
fun covariant() {
    val eduBookStore: BookStore<EduBook> = BookStore<EduBook>()
    val bookStore: BookStore<Book> = eduBookStore

    val book: Book = bookStore.getBook()
    val eduBook: Book = eduBookStore.getBook()
}

open class Waste

class DryWaste : Waste()

class Dustbin<in T : Waste> {
    fun put(t: T) {

    }
}

// 逆变
fun contravariant() {
    val dustbin: Dustbin<Waste> = Dustbin()
    val dryDustbin: Dustbin<DryWaste> = dustbin

    val waste = Waste()
    val dryWaste = DryWaste()

    dustbin.put(waste)
    dustbin.put(dryWaste)

//    dryDustbin.put(waste)
    dryDustbin.put(dryWaste)
}

//编译后
//fun  maxOf(a: Comparable, b: Comparable): Comparable {
//    return if (a > b) a else b
//}

inline fun <reified T> genericMethod(t: T) {
//    val t = T() //错误，无法确定是否有无参的构造器
    val ts = Array<T>(3) { TODO() }
    val jclass = T::class.java
    val list = ArrayList<T>()
}
