package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        Integer a = 10;
        Class cls = Integer.class;
        try {
            Constructor<Integer> integerConstructor = cls.getConstructor(new Class[]{String.class});
            try {
                integerConstructor.newInstance(1);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println(a.getClass());
        System.out.println(cls);
        Class<Comparator> clss = Comparator.class;
        System.out.println(clss);

        System.out.println(int.class);
        Class<Integer> integerClass = int.class;
        System.out.println(integerClass);
        Class<Void> voidClass = void.class;
        System.out.println(voidClass);

        int[][] is = new int[1][1];
        Class<? extends int[][]> clsss = is.getClass();
        System.out.println(clsss);


        System.out.println(Size.SMALL.getClass());

        try {
            Class<?> clad = Class.forName("java.applet.Applet");
            System.out.println(clad.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    enum Size {
        SMALL, MEDIUM
    }
}
