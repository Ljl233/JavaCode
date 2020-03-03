package Lambda;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test2 {
    private List<Employee> emplyees = Arrays.asList(
            new Employee("Harry", 23, 444.44),
            new Employee("aaa", 54, 5555.555),
            new Employee("bbb", 18, 4444.44),
            new Employee("ccc", 25, 4444.66)
    );

    @Test
    void test1() {
        Collections.sort(emplyees, (o1, o2) ->
                o1.getAge() == o2.getAge() ?
                        o1.getName().compareTo(o2.getName())
                        : Integer.compare(o1.getAge(), o2.getAge())
        );

        for (Employee e : emplyees) System.out.println(e);
    }

    @Test
    void test2() {
        String s = upper("string", String::toUpperCase);
        System.out.println(s);
    }

    private String upper(String s, MyPredicate mp) {
        return mp.getValues(s);
    }
}

@FunctionalInterface
interface MyPredicate {
    public String getValues(String s);
}
