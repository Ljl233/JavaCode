package thread;

public class Alipay {
    private double[] accounts;

    public Alipay(int n, double money) {
        accounts = new double[n];

        for (int i = 0; i < n; i++) {
            accounts[i] = money;
        }
    }

    public synchronized void transfer(int from, int to, double amount) throws InterruptedException {
        while (accounts[from] < amount) {
            wait();
        }
        accounts[from] = accounts[from] - amount;
        accounts[to] = accounts[to] + amount;
        notifyAll();
    }
}
