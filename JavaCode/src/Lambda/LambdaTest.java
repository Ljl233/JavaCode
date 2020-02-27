package Lambda;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;

public class LambdaTest {
    /**
     * lambda 语法格式      （）-> {}
     * <p>
     * 左侧：参数
     * 右侧：所要执行的功能
     * <p>
     * 一、无参，无返回值
     * <p>
     * 二、无参有返回值
     * <p>
     * 三、一个参数，无返回值
     * <p>
     * 四、一个参数一个返回值
     * <p>
     * 五、两个参数，一个返回值
     *
     * 参数的类型可以省略，因为可以进行类型推断
     *
     * 函数式接口：只有一个抽象方法的接口，可以使用 @FunctionalInterface 注解
     */

    @Test
    void test1() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello runnable!");
            }
        };
        runnable.run();

        System.out.println("-------------------------------");

        Runnable runnable1 = () -> System.out.println("hello lambda runnable!");
        runnable1.run();
    }

    @Test
    void test2() {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("consumer");

        Consumer<String> consumer1 = (s) -> System.out.println(s + "//////////");
        consumer1.accept("consumer");
    }

    @Test
    void test3() {
        Comparator<Integer> comparator = (a, b) -> {
            System.out.println("comparator");
            return Integer.compare(a, b);
        };

        Comparator<Integer> comparator1 = Integer::compareTo;
    }

    @Test
    void test4() {
        String[] strings = {"aaaaa"};
     //   strings = {"aaaaa"};//不被允许因为无法进行类型推断

    }
}
