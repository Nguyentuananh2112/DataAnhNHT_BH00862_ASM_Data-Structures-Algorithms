package Examplee;

public class FunctionCallExample {

    public static void main(String[] args) {
        System.out.println("Main starts");
        functionA();
        System.out.println("Main ends");
    }

    public static void functionA() {
        System.out.println("In functionA");
        functionB();
        System.out.println("Back to functionA");
    }

    public static void functionB() {
        System.out.println("In functionB");
    }
}

