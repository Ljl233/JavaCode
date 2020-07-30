package generics


fun main() {
    val queryMap: QueryMap<*, *> = QueryMap<String, Int>()
    queryMap.getKey()
    queryMap.getValue()


    val hashMap = getHashMap()
    hashMap[" "] = 1
}

fun getHashMap(): HashMap<String, Int> {
    return HashMap<String, Int>()
}

class QueryMap<out K : CharSequence, out V : Any?> {
    fun getKey(): K = TODO()
    fun getValue(): V = TODO()
}