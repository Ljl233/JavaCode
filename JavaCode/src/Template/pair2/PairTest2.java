package Template.pair2;

import Template.Pair;

import java.time.LocalDate;

public class PairTest2 {
    public static void main(String[] args) {
        LocalDate[] birthdays = {
                LocalDate.of(1992, 2, 1),
                LocalDate.of(1987, 4, 2),
                LocalDate.of(1989, 6, 23),
                LocalDate.of(1999, 9, 21),
        };
        Pair<LocalDate> mm = ArrayAlg.minmax(birthdays);
        System.out.println("min=" + mm.getFirst());
        System.out.println("max=" + mm.getSecond());
    }
}

class ArrayAlg {
    static <T extends Comparable> Pair<T> minmax(T[] a) {
        if (a == null && a.length == 0) return null;
        T min = a[0];
        T max = a[0];
        for (T t : a) {
            if (min.compareTo(t) > 0) min = t;
            if (max.compareTo(t) < 0) max = t;
        }
        return new Pair<>(min, max);
    }

}