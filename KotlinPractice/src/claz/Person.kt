package claz

open class Person(age: Int, name: String) {
    //property
    var age: Int = age
        get() = field
        set(value){
            field=value
        }
    var name: String = name

}

fun main() {

    //属性引用
    var ageRef = Person::age

    val person = Person(3, "Barry")
    var age = person::age

}