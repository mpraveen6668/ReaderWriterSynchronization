package readerwriter;

public class Reader extends Thread {

    private final SharedResource resource;

    public Reader(String name, SharedResource resource) {

        super(name);

        this.resource = resource;

    }

    @Override
    public void run() {

        System.out.println(getName() + " wants to read");

        try {

            resource.read(getName());

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

        }

    }

}