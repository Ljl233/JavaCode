package annotation;

import java.lang.annotation.*;
import java.sql.Date;

@a(2)
public class AnnoTest1 extends base {

    @Deprecated
    @SuppressWarnings("all")
    void a() {
        long utc = Date.UTC(1, 1, 1, 1, 1, 1);
    }

    void b() {
        a();
    }

    @Override
    void f() {
        super.f();
    }
}

class base {
    void f() {
        System.out.println("I'm father method");
    }
}

@Documented
@Target({ElementType.METHOD, ElementType.PACKAGE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface a {
    int value() default 1;

//    String string();
//
//    ElementType em();
//
//    ElementType[] ems();
//
//    String[] ss();
//
//    Override s();
}
