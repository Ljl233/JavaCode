package proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    public interface IService {
        void buyTicket();
    }


    static class TrainService implements IService {

        @Override
        public void buyTicket() {
            System.out.println("买火车票");
        }
    }

    static class ProxyService implements IService {

        @Override
        public void buyTicket() {
            IService service = new TrainService();
            service.buyTicket();
            System.out.println("在携程上买的");
        }
    }

    static class MyInvocationHandler implements InvocationHandler {

        private Object realObject;

        public MyInvocationHandler(Object object) {
            realObject = object;
        }

        /**
         * 类似与静态代理中重写抽象方法的逻辑，调用被代理对象的方法
         *
         * @param proxy  代理对象本身，被动态创建的代理类的实例对象，一般
         * @param method 正在被调用的方法
         * @param args   被调用方法所需要的参数
         * @return 方法执行的结果
         * @throws Throwable
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            //输出跟踪调试信息
            System.out.println("enter :" + method.getName());

            Object result = method.invoke(realObject, args);
            System.out.println("在携程上买的(动态代理)");

            System.out.println("out :" + method.getName());

            return result;
        }
    }

    public static void main(String[] args) {
//        IService proxy = new ProxyService();
//        proxy.buyTicket();

        IService trainService = new TrainService();
        IService proxy = (IService) Proxy.newProxyInstance(
                IService.class.getClassLoader(),
                new Class[]{IService.class},
                new MyInvocationHandler(trainService));
        proxy.buyTicket();

/*
        Class<?> proxyCls = Proxy.getProxyClass(IService.class.getClassLoader());
        Constructor<?> constructor = proxyCls.getConstructor(new Class<?>[]{IService.class});
        InvocationHandler h = new MyInvocationHandler(trainService);
        IService proxy = constructor.newInstance(h);

 */
    }

}

/*
final class $Proxy0 extends Proxy implements ProxyTest.IService {
    private static Method m1;
    private static Method m3;
    private static Method m2;
    private static Method m0;

    static {
        m1 = Class.forName("java.lang.Object").getMethod("equals",
                new Class[]{Class.forName("java.lang.Object")});
        m3 = Class.forName("laoma.demo.proxy.SimpleJDKDynamicProxyDemo$IService")
                .getMethod("buyTicket", new Class[0]);
        m2 = Class.forName("java.lang.Object").getMethod("toString", new Class[0]);
        m0 = Class.forName("java.lang.Object").getMethod("hashCode", new Class[0]);
    }

    public $Proxy0(InvocationHandler paramInvocationHandler) {
        super(paramInvocationHandler);
    }

    @Override
    public void buyTicket() {
        return this.h.invoke(this, m3, null);
    }

    public final boolean equals(Object paramObject) {
        return ((Boolean) this.h.invoke(this, m1,
                new Object[]{paramObject})).booleanValue();
    }

    public final String toString() {
        return (String) this.h.invoke(this, m2, null);
    }

    public final int hashCode() {
        return ((Integer) this.h.invoke(this, m0, null)).intValue();
    }
}

 */