- 这里会记录一些我在java上的一些test

# callback
> 我想要实现一个方法，
就是让另一个类得到异步里的结果，这时候应该是用到异步回调。
```java

public class Boss implements Callback {
    public void ask() {
        System.out.println("那个方案出来！");
    }

    @Override
    public void send(String s) {
        System.out.print("Boss得到的回答是：" + s);
    }
}

interface Callback {
    void send(String s);
}


public class Stuff {
    void answer(Callback callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                callback.send("我想好了就告诉你！");
            }
        }) .start();
    }
}
public class Test {
    public static void main(String[] args) {
        Boss boss = new Boss();
        Stuff stuff = new Stuff();
        boss.ask();
        stuff.answer(boss);
    }
}
```
- 先定义一个接口，让Boss类实现，再将接口以参数的形式传入
Stuff类中的方法，在方法中调用接口的方法获得另一个线程中的内容。
但是感觉还是没有达到想要的效果。
- 我不让Boss去实现这个接口而是直接调用Stuff中的方法，
感觉这个和OnClickListener的回调有点像，用的比较舒服，
虽然也不知道有什么不一样。

# 继承
子类继承父类可以直接使用父类的公有方法，和公有变量。不能直接使用私有变量和私有方法，可以用公共方法getter和setter对私有变量进行操作