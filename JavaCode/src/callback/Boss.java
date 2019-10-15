package callback;

public class Boss {
    Stuff stuff = new Stuff();

    public void ask() {
        System.out.println("那个方案出来！");

        stuff.answer(new Callback() {
            @Override
            public void send(String s) {
                System.out.print("Boss得到的回答是：" + s);

            }
        });
    }


}

interface Callback {
    void send(String s);
}
