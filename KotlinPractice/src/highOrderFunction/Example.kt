package highOrderFunction

import java.io.File

abstract class Animal

//class Person(private var name: String, var age: Int) : Animal() {
//    constructor(age: Int) : this("unknown", age) {
//
//    }
//}
class Person(private var name: String, var age: Int) {
    private var firstName: String = ""

    var bornAge: Int = 0
        private set
}

val persons = HashMap<String, Person>()
fun Person(name: String): Person {
    return persons[name] ?: Person(name, 1).also { persons[name] = it }
}


fun main() {
    val person = Person("Barry", 18)

    person.let(::println)
    person.run(::println)

    person.also {
        it.age = 19
    }

    person.apply {
        this.age = 18
    }

    File(".../build.gradle").inputStream().reader().buffered()
        .use {
            it.forEachLine {
                println(it)
            }
        }

    fun test():Unit{
        var a=1
    }

    fun test2(): Unit {

    }

}
