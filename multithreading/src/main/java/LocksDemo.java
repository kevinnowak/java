import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class LocksDemo {

    private final Counter counter = new Counter();
    private final SynchronizedCounter synchronizedCounter = new SynchronizedCounter();

    public void demoCounter() {
        try (ExecutorService service = Executors.newCachedThreadPool()) {
            IntStream.range(0, 1_000)
                    .forEach(i -> service.submit(counter::increment));
        }

        IO.println("Counter count = " + counter.getCount());
    }

    public void demoSynchronizedCounter() {
        try (ExecutorService service = Executors.newCachedThreadPool()) {
            IntStream.range(0, 1_000)
                    .forEach(i -> service.submit(synchronizedCounter::increment));

        }

        IO.println("Synchronized Counter count = " + synchronizedCounter.getCount());
    }

    static void main() {
        LocksDemo demo = new LocksDemo();
        demo.demoCounter();
        demo.demoSynchronizedCounter();
    }
}
