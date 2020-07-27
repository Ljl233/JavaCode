package generics

import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

class Box<T>(t: T) {
    var value = t;
    val box = Box("String")

    fun main() {
        box.value

        var stringList: List<String> = ArrayList<String>()
        var objectList: List<Any> = ArrayList<String>()

    }

}

