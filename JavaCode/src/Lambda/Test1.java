package Lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Test1 {

    private List<Employee> emplyees = Arrays.asList(
            new Employee("Harry", 23, 444.44),
            new Employee("aaa", 54, 5555.555),
            new Employee("bbb", 18, 4444.44),
            new Employee("ccc", 25, 4444.66)
    );

    /**
     * 每个需求需要创建一个方法
     */

    @Test
    void test1() {

        List<Employee> employees1 = filteEmployeesByAge(emplyees);
        for (Employee e : employees1) {
            System.out.println(e.toString());
        }

        System.out.println("----------------------------");

        List<Employee> employees2 = filterEmployeeBySalary(emplyees);
        for (Employee e : employees2) {
            System.out.println(e.toString());
        }

    }

    private List<Employee> filteEmployeesByAge(List<Employee> emplyees) {
        List<Employee> list = new ArrayList<>();
        for (Employee e : emplyees) {
            if (e.getAge() > 25)
                list.add(e);
        }
        return list;
    }

    private List<Employee> filterEmployeeBySalary(List<Employee> emplyees) {
        List<Employee> list = new ArrayList<>();

        for (Employee e : emplyees) {
            if (e.getSalary() > 4444.0) list.add(e);
        }
        return list;
    }

    /**
     * 调用的时候只需要一个方法，参数不同
     */
    @Test
    void test2() {
        List<Employee> employees = filterEmployee(emplyees, e -> e.getSalary() > 4444);

        for (
                Employee e : employees) {
            System.out.println(e.toString());
        }

        System.out.println("-------------------------");

        employees.forEach(e -> System.out.println(e.toString()));

        System.out.println("-------------------------");

        employees.stream()
                .filter(e -> e.getAge() > 25)
                .forEach(System.out::println);

    }

    private List<Employee> filterEmployee(List<Employee> list, filterInterface<Employee> fi) {
        List<Employee> employees = new ArrayList<>();

        for (Employee e : list) {
            if (fi.filter(e))
                employees.add(e);
        }
        return employees;

    }

}

@FunctionalInterface
interface filterInterface<T> {
    boolean filter(T t);
}

class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {

        return name + ", " + age + ", " + salary;
    }
}
