package annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Pro {
    String className();

    String methodName();
}

/*

public class ProImpl implements Pro {

    @Override
    public String className() {
        return null;
    }

    @Override
    public String methodName() {
        return null;
    }

}
*/

