package thread;

public class TestThread extends Thread {

    @Override
    public void run() {
        System.out.println("Hello Thread!");
        int i = 1;

    }

    public static void main(String[] args) {
        say(new Callback() {
            @Override
            public void tell(int i) {
                System.out.println("i=" + i);
            }
        });
    }

    public static void say(Callback callback) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 3;
                callback.tell(i);
            }
        });
        thread.start();
    }

    interface Callback {
        void tell(int i);
    }
}
