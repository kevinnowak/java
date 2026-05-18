import java.util.concurrent.CountDownLatch;

public class LatchDemo {

    static void main() throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch endSignal = new CountDownLatch(5);

        for (int i = 0; i < 5; i++) {
            new Thread(new Worker(i, startSignal, endSignal)).start();
        }

        IO.println("Work done before starting workers...");
        startSignal.countDown(); // Go!
        IO.println("Doing work while workers are running");
        endSignal.await();
        IO.println("All workers finished");
    }
}
