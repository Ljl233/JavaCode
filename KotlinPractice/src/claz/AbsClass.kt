package claz

//可见性默认public
abstract class AbsClass{
    abstract fun absMethod()

    //open表示可以被覆写
    open fun overridableMethod(){

    }

    //非抽象方法默认不可以被覆写
    fun nonOverridableMethod(){

    }
}
