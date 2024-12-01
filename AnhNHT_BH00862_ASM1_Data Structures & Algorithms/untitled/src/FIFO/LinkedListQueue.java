package FIFO;

public class LinkedListQueue {
    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node front, rear;

    public LinkedListQueue() {
        front = rear = null;
    }

    // Enqueue operation
    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    // Dequeue operation
    public int dequeue() {
        if (front == null) {
            System.out.println("Queue is empty");
            return -1;
        }
        int value = front.value;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return value;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Peek at the front element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return front.value;
    }
}

