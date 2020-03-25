package claz

open class SimpleClass(var x: Int, var y: String) :
    AbsClass(), SimpleInf {
    //x,y 既是主构造器的参数，也是这个类的成员属性，需要在构造器中初始化
    var z = 0L

    open fun zzz(string: String) {
        println(string)
    }

    override fun simpleMethod() {
        println("interface method")
    }

    override fun absMethod() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun overridableMethod() {

    }

}

class SimpleClass2(x: Int, y: String) : SimpleClass(x, y) {
    override fun zzz(string: String) {

    }

    override fun absMethod() {


    }
}

fun main() {
    var simpleClass = SimpleClass(1, "Hello")
    println(simpleClass.x)
    println(simpleClass.y)
    println(simpleClass.z)
    simpleClass.zzz("sleeping")

    //不允许为空
    val nonNull: String = "Hello"

    //允许为空
    var nullable: String? = "null"

    //强制转换为不可空的类型 ！！
//    var length = nullable!!.length
//
    //安全访问运算符 ?. 返回的是一个Int? 可空类型
    var length2 = nullable?.length


    var length3 = nullable?.length ?: 0//elvis 表达式前面为空时返回0


}