# Reader-Writer Synchronization Problem Using Threads

## Project Overview

This project demonstrates the Reader-Writer Synchronization Problem using Java Threads and Semaphores.

The main objective is to allow multiple readers to access a shared resource simultaneously while ensuring that writers get exclusive access to the resource.

## Technologies Used

- Java
- Java Threads
- Semaphore
- Eclipse IDE

## Project Structure

- `SharedResource.java` – Manages the shared data and synchronization.
- `Reader.java` – Represents a reader thread.
- `Writer.java` – Represents a writer thread.
- `Main.java` – Creates and starts reader and writer threads.

## Synchronization Mechanism

The project uses two semaphores:

### 1. Mutex Semaphore

The mutex semaphore protects the `readerCount` variable from simultaneous modification by multiple reader threads.

### 2. Write Semaphore

The write semaphore ensures that:

- Multiple readers can read simultaneously.
- Only one writer can write at a time.
- Writers cannot write while readers are accessing the resource.

## Test Configuration

The program was tested with:

- 4 Reader Threads
- 5 Writer Threads

Total Threads:

**9 Threads**

## Expected Behavior

1. Multiple readers can access the shared resource simultaneously.
2. Writers wait while readers are accessing the resource.
3. Writers access the shared resource one at a time.
4. Each writer updates the shared data.
5. The program terminates after all threads complete.

## Sample Output

Reader-1 started reading. Data = 0  
Reader-2 started reading. Data = 0  
Reader-3 started reading. Data = 0  
Reader-4 started reading. Data = 0  

Writer-1 started writing.  
Writer-1 finished writing. New data = 183  

Writer-5 started writing.  
Writer-5 finished writing. New data = 638  

Simulation complete.

## Conclusion

The project successfully demonstrates thread synchronization in Java using the Reader-Writer problem. It shows how semaphores can be used to coordinate concurrent access to a shared resource and prevent conflicting read/write operations.