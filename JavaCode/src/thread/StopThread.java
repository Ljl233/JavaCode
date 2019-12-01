package thread;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class StopThread {
    //    public static void main(String[] args) {
//        Thread thread = new Thread(new MyRunner(), "My thread");
//        thread.start();
//
//        try {
//            TimeUnit.MILLISECONDS.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        thread.interrupt();
//    }
//
//    public static class MyRunner implements Runnable {
//
//        @Override
//        public void run() {
//            int i = 0;
//            while (!Thread.interrupted()) {
//                System.out.println(i);
//                i++;
//            }
//        }
//    }


    public static void main(String[] args) throws InterruptedException {
        TestRunnable runnable = new TestRunnable();
        Thread thread = new Thread(runnable);
        thread.start();

        TimeUnit.MILLISECONDS.sleep(10);
        runnable.cancel();
    }

    public static class TestRunnable implements Runnable {
        volatile boolean on = true;
        int i = 1;

        @Override
        public void run() {
            while (on) {
                System.out.println(i);
                i++;
            }
        }

        public void cancel() {
            on = false;
        }
    }




}