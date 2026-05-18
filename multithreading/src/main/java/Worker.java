import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable {

    private int id;
    private CountDownLatch startSignal;
    private CountDownLatch endSignal;

    public Worker(int id, CountDownLatch startSignal, CountDownLatch endSignal) {
        this.id = id;
        this.startSignal = startSignal;
        this.endSignal = endSignal;
    }

    @Override
    public void run() {
        try {
            IO.println(String.format("%d waiting to start...%n", id));
            startSignal.await();
            IO.println(String.format("%d running to completion%n", id));
            endSignal.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
