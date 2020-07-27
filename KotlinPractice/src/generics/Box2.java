package generics;

import claz.AbsClass;

import java.util.ArrayList;
import java.util.List;
//
//public class Box2<T> {
//    T value;
//
//    Box2(T t) {
//        value = t;
//    }
//
//    public static void main(String[] args) {
//        Box2<? super fruit> box2 = new Box2<food>("box2");
//
//        List<? super fruit> list = new ArrayList<>();
//        list.add(new fruit());
//        list.add(new apple());
//
//
//        //协变
//        ArrayList<? extends Number> list1 = new ArrayList<Integer>();
////逆变
//        ArrayList<? super Integer> list2 = new ArrayList<Number>();
//        list1.add(1); //error
//
//        ArrayList<Object> list3 = new ArrayList<>();
//        list3.add(1);
//
//    }
//
//    void check(Source<String> stringSource) {
//        Source<? extends Object> objectSource = stringSource;
//    }
//}
//
//class fruit extends food {
//
//}
//
//class food {
//
//}
//
//class apple extends fruit {
//}