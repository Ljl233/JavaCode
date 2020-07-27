package type

import kotlin.properties.Delegates

interface Api {
    fun a()
    fun b()
    fun c()
}

class ApiImpl : Api {
    override fun a() {
        TODO("Not yet implemented")
    }

    override fun b() {
        TODO("Not yet implemented")
    }

    override fun c() {
        TODO("Not yet implemented")
    }
}

class ApiWrapper(val api: Api) : Api {
    override fun a() {
        api.a()
    }

    override fun b() {
        api.b()
    }

    override fun c() {
        api.c()
    }
}

class ApiDelegate(val api: Api) : Api by api {
    //api 替代 ApiDelegate 实现接口 Api
// 对于对象api的唯一尤其就是实现代理的接口
    override fun a() {

    }

}

class SuperArray<E>(
    private val list: MutableList<E?> = ArrayList(),
    private val map: MutableMap<String, E> = HashMap()
) : MutableList<E?> by list, MutableMap<String, E> by map {

    override fun clear() {
        list.clear()
        map.clear()
    }

    override fun isEmpty(): Boolean {
        return list.isEmpty() && map.isEmpty()
    }

    override val size: Int
        get() = list.size + map.size


}

class Person(val name: String) {
    val firstName by lazy { name.split(" ")[0] }
}

class StateManager {
    var state: Int by Delegates.observable(0) { property, oldValue, newValue ->
        println("state changed from $oldValue -> $newValue")
    }
}