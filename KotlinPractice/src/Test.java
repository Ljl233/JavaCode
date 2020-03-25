import java.util.Timer;

public class Test {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
        System.out.println(System.currentTimeMillis());
    }
}
