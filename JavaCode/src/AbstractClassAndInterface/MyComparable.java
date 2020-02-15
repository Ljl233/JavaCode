package AbstractClassAndInterface;

public interface MyComparable {
    int a = 1;
    static final int b = 1;//接口里的变量默认是static final

    static void test() {
        System.out.println("test");
        //testB();
        //静态方法不能调用默认方法,静态方法只能调用静态方法
    }

    static void testA() {
        System.out.println("a=" + a);
    }

    default void testB() {
        testA();//可以调用静态方法
        System.out.println("b=" + b);
    }

    default void testDefault() {
        testB();//默认方法可以调用默认方法
    }

   <T> int compare(T other);
}
