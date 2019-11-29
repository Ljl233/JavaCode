package thread;

public class TestRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello runnable ");
    }

    public static void main(String[] args) {
        TestRunnable runnable = new TestRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
