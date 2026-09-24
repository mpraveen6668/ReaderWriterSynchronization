package readerwriter;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // Create one shared resource
        SharedResource resource = new SharedResource();

        // Number of Readers and Writers
        int numReaders = 4;
        int numWriters = 5;

        // Create Reader and Writer arrays
        Reader[] readers = new Reader[numReaders];
        Writer[] writers = new Writer[numWriters];

        // Create Reader threads
        for (int i = 0; i < numReaders; i++) {
            readers[i] = new Reader("Reader-" + (i + 1), resource);
        }

        // Create Writer threads
        for (int i = 0; i < numWriters; i++) {
            writers[i] = new Writer("Writer-" + (i + 1), resource);
        }

        // Start Reader threads
        for (Reader reader : readers) {
            reader.start();
        }

        // Start Writer threads
        for (Writer writer : writers) {
            writer.start();
        }

        // Wait for all Readers to finish
        for (Reader reader : readers) {
            reader.join();
        }

        // Wait for all Writers to finish
        for (Writer writer : writers) {
            writer.join();
        }

        System.out.println("Simulation complete.");
    }
}