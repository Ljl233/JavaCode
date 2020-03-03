package annotation;

import java.lang.annotation.Annotation;

@Pro(className = "annotation.Demo1", methodName = "show")
public class ReflectTest {

    public static void main(String[] args) {
        Class<ReflectTest> reflectTestClass = ReflectTest.class;

        //其实生成一个该注解接口的子类实现对象
        /*

        public class ProImpl implements Pro {

            @Override
            public String className() {
                return "annotation.Demo1";
            }

            @Override
            public String methodName() {
                return "show";
            }

        }
        */
        Pro annotation = reflectTestClass.getAnnotation(Pro.class);
        String className = annotation.className();
        String methodName = annotation.methodName();
        System.out.println(className);
        System.out.println(methodName);
    }
}
