package Examplee;

public class StackFrameExample {

    public static void main(String[] args) {
        int x = 10;
        int result = addNumbers(x, 20); // Calls addNumbers
        System.out.println("Result: " + result);
    }

    public static int addNumbers(int a, int b) {
        return a + b; // Returns 30
    }
}

