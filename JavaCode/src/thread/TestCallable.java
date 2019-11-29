package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestCallable implements Callable {
    @Override
    public Object call() throws Exception {

            return "Hello callable";
    }

    public static void main(String[] args) {
        Callable callable = new TestCallable();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future future = executorService.submit(callable);

        try {
            System.out.println(future.get());
            System.out.println("finish");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
