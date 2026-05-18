import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class LocksDemo {

    private final Counter counter = new Counter();
    private final SynchronizedCounter synchronizedCounter = new SynchronizedCounter();
    private final LockedCounter lockedCounter = new LockedCounter();
    private final AtomicCounter atomicCounter = new AtomicCounter();

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

    public void demoLockedCounter() {
        try (ExecutorService service = Executors.newCachedThreadPool()) {
            IntStream.range(0, 1_000)
                    .forEach(i -> service.submit(lockedCounter::increment));

        }

        IO.println("Locked Counter count = " + lockedCounter.getCount());
    }

    public void demoAtomicCounter() {
        try (ExecutorService service = Executors.newCachedThreadPool()) {
            IntStream.range(0, 1_000)
                    .forEach(i -> service.submit(atomicCounter::increment));

        }

        IO.println("Atomic Counter count = " + atomicCounter.getCount());
    }

    static void main() {
        LocksDemo demo = new LocksDemo();
        demo.demoCounter();
        demo.demoSynchronizedCounter();
        demo.demoLockedCounter();
        demo.demoAtomicCounter();
    }
}
