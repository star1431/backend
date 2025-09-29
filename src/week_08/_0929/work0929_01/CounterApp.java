package week_08._0929.work0929_01;


public class CounterApp {
    public static void main(String[] args) {
        IncrementCounter inc = new IncrementCounter(1, 100);
        DecrementCounter dec = new DecrementCounter(1, 100);

        Thread incrementThread = new Thread(inc);
        Thread decrementThread = new Thread(dec);

        incrementThread.start();
        decrementThread.start();
    }
}
