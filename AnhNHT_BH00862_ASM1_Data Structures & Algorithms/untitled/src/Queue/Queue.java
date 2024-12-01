package Queue;

public class Queue {
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int nItems;

    // Constructor to initialize the queue
    public Queue(int size) {
        this.maxSize = size;
        this.queueArray = new int[maxSize];
        this.front = 0;
        this.rear = -1;
        this.nItems = 0;
    }

    // Enqueue an element at the rear
    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            if (rear == maxSize - 1) {
                rear = -1; // Wrap around
            }
            queueArray[++rear] = element;
            nItems++;
        }
    }

    // Dequeue an element from the front
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            int temp = queueArray[front++];
            if (front == maxSize) {
                front = 0; // Wrap around
            }
            nItems--;
            return temp;
        }
    }

    // Peek at the front element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            return queueArray[front];
        }
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return (nItems == 0);
    }

    // Check if the queue is full
    public boolean isFull() {
        return (nItems == maxSize);
    }

    // Main method to demonstrate queue operations
    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        System.out.println("Front element: " + queue.peek());  // Outputs 10
        System.out.println("Dequeued element: " + queue.dequeue()); // Outputs 10
        System.out.println("Front element after dequeue: " + queue.peek()); // Outputs 20
    }
}
