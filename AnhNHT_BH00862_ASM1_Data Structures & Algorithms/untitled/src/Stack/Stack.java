package Stack;

import java.util.EmptyStackException;

public class Stack {
    private int maxSize;
    private int[] stackArray;
    private int top;

    // Constructor to initialize the stack
    public Stack(int size) {
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.top = -1;
    }

    // Push an element onto the stack
    public void push(int element) {
        if (isFull()) {
            System.out.println("Stack is full");
        } else {
            stackArray[++top] = element;
        }
    }

    // Pop an element from the stack
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return stackArray[top--];
        }
    }

    // Peek at the top element without removing it
    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return stackArray[top];
        }
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }

    // Check if the stack is full
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    // Main method to demonstrate stack operations
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(10);
        stack.push(20);
        System.out.println("Top element: " + stack.peek());  // Outputs 20
        System.out.println("Popped element: " + stack.pop()); // Outputs 20
        System.out.println("Top element after pop: " + stack.peek()); // Outputs 10
    }
}
