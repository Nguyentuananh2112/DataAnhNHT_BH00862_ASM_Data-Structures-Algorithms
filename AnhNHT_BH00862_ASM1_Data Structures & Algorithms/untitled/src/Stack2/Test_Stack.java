package Stack2;

public class Test_Stack {
    protected int capacity;

    public static final int CAPACITY = 10;

    protected int[] stackRep;
    protected int top = -1;

    public Test_Stack() {
        this(CAPACITY);
    }

    public Test_Stack(int cap) {
        capacity = cap;
        stackRep = new int[capacity];
    }

    public int size() {
        return (top + 1);
    }
    public boolean isEmpty() {
        return (top < 0);
    }

    public void push(int data) throws Exception {
        if (size() == capacity) {
            throw new Exception("Stack is full");
        }
        stackRep[++top] = data;
    }

    public int pop() throws Exception {
        int data ;
        if (isEmpty()) {
            throw new Exception("Stack is empty");
        }
        data = stackRep[top];
        stackRep[top--] = Integer.MIN_VALUE;
        return data;
    }
    public String toString() {
        String s;
        s = "[";
        if (size() > 0) {
            s += stackRep[0];
        }
        if (size() > 1) {
            for (int i = 1; i < size(); i++) {
                s += ", " + stackRep[i];
            }
        }
        return s + "]";
    }


}
