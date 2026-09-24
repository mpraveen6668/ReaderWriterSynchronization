package readerwriter;

import java.util.concurrent.Semaphore;

public class SharedResource {

    private int data = 0;
    private int readerCount = 0;

    private final Semaphore mutex = new Semaphore(1);
    private final Semaphore writeSemaphore = new Semaphore(1);

    public void read(String readerName) throws InterruptedException {

        // Reader entry section
        mutex.acquire();
        readerCount++;

        // First reader blocks writers
        if (readerCount == 1) {
            writeSemaphore.acquire();
        }

        // Release mutex so other readers can update readerCount
        mutex.release();

        // Critical section: reading
        System.out.println(readerName + " started reading. Data = " + data);

        Thread.sleep(1000);

        System.out.println(readerName + " finished reading.");

        // Reader exit section
        mutex.acquire();
        readerCount--;

        // Last reader allows writers again
        if (readerCount == 0) {
            writeSemaphore.release();
        }

        mutex.release();
    }

    public void write(String writerName, int newValue) throws InterruptedException {

        System.out.println(writerName
                + " wants to write. Waiting for access...");

        // Writer needs exclusive access
        writeSemaphore.acquire();

        System.out.println(writerName + " started writing.");

        Thread.sleep(1500);

        data = newValue;

        System.out.println(writerName
                + " finished writing. New data = " + data);

        // Allow the next reader or writer to access
        writeSemaphore.release();
    }
}