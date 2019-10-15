package HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //Map<key,value>
        Map<String, Integer> hashmap = new HashMap<>();
        //添加键值对
        //添加元素时，如果key已经存在，则返回旧value，并将新的value存在该key中；
        hashmap.put("bb",1);
        hashmap.put("aa",1);
        hashmap.put("bb",2);
        hashmap.put("cc",3);
        //put方法会覆盖原有的value，putIfAbsent（key，value）不会

        hashmap.putIfAbsent("aa",4);//没有覆盖key为aa的
        //元素的遍历
//        Iterator iterator=hashmap.keySet().iterator();
//        while (iterator.hasNext()){
//            String key =(String)iterator.next();
//            System.out.println("key:"+key+"="+"value:"+hashmap.get(key));
//        }
        //删除元素
        hashmap.remove("bb");
        hashmap.remove("aa",5);

        //元素的遍历
        Iterator iterator=hashmap.keySet().iterator();
        while (iterator.hasNext()){
            String key =(String)iterator.next();
            System.out.println("key:"+key+"="+"value:"+hashmap.get(key));
        }
        //获取元素
        hashmap.get("cc");
        //containskey   containsValue   判断是否存在
        //Integer bbValue = hashmap.containsKey("bb")?hashmap.get("bb"):-1;
        //可以用getOrDefault
        hashmap.getOrDefault("aa",-1);//key不存在则返回默认值value-1

        //替换元素
        hashmap.replace("ff",5);
        hashmap.replace("aa",5);
        //对于存在的key，调用replace方法，会替换原来的value，并返回旧value，这和put的效果是一样的；
        // 对于不存在的key，replace方法什么都不做。
        // 这就是他和put的区别（put在key不存在时将新key-value加入map）。

        //第二种遍历方法
        Iterator iterator1=hashmap.entrySet().iterator();
        while(iterator1.hasNext()){
            Map.Entry entry= (Map.Entry)iterator1.next();
            String key =(String)entry.getKey();
            Integer value =(Integer)entry.getValue();
            System.out.println("key:"+key+"="+"value:"+value);
        }
    }
}
