package callback;

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
