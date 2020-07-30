package dataClass;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class JavaEnum {
    enum State implements Runnable {
        Idle(0) {
            @Override
            public void run() {
                System.out.println("run for idle");
            }
        }, Busy(1) {
            @Override
            public void run() {
                System.out.println("run for busy");
            }
        };
        int idd;

        State(int idd) {
            this.idd = idd;
        }
    }

    public static void main(String[] args) {
        System.out.println(State.Idle.name());
        System.out.println(State.Idle.ordinal());
        List<Integer> list = new ArrayList<>();
    }


    public static <T extends Comparable<T>> T maxOf(T a, T b) {
        if (a.compareTo(b) > 0)
            return a;
        else return b;
    }

    public static <T extends Comparable<T> & Supplier<R>, R extends Number> R callMax(T a, T b) {
        if (a.compareTo(b) > 0) return a.get();
        else return b.get();
    }
}

