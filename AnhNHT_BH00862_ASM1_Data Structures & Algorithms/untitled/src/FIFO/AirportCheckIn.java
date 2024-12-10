package FIFO;

public class AirportCheckIn {
    public static void main(String[] args) {
        // Create a queue with a capacity of 5 passengers
        ArrayQueue checkInQueue = new ArrayQueue(5);

        // Passengers arrive at the check-in counter
        System.out.println("Passenger 101 arrives");
        checkInQueue.enqueue(101); // Passenger 101 arrives

        System.out.println("Passenger 102 arrives");
        checkInQueue.enqueue(102); // Passenger 102 arrives

        System.out.println("Passenger 103 arrives");
        checkInQueue.enqueue(103); // Passenger 103 arrives

        // Serve passengers at the check-in counter
        System.out.println("Checking in passenger: " + checkInQueue.dequeue()); // Checking in passenger 101
        System.out.println("Checking in passenger: " + checkInQueue.dequeue()); // Checking in passenger 102

        // More passengers arrive
        System.out.println("Passenger 104 arrives");
        checkInQueue.enqueue(104); // Passenger 104 arrives

        System.out.println("Passenger 105 arrives");
        checkInQueue.enqueue(105); // Passenger 105 arrives

        // Serve the rest of the passengers
        System.out.println("Checking in passenger: " + checkInQueue.dequeue()); // Checking in passenger 103
        System.out.println("Checking in passenger: " + checkInQueue.dequeue()); // Checking in passenger 104
        System.out.println("Checking in passenger: " + checkInQueue.dequeue()); // Checking in passenger 105
    }
}

