package readerwriter;

import java.util.Random;

public class Writer extends Thread {

    private final SharedResource resource;

    private static final Random random = new Random();

    public Writer(String name, SharedResource resource) {
        super(name);
        this.resource = resource;
    }

    @Override
    public void run() {

        int newValue = random.nextInt(1000);

        try {
            resource.write(getName(), newValue);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}