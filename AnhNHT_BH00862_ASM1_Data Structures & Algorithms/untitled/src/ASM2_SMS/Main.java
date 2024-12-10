package ASM2_SMS;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagement sm = new StudentManagement();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Nhập số lượng sinh viên cần tạo tự động
        System.out.print("Enter the number of students to generate: ");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Tạo sinh viên tự động
        for (int i = 1; i <= numberOfStudents; i++) {
            String id = String.format("ID%04d", i); // ID tự động: ID0001, ID0002, ...
            String name = "Student" + i; // Tên tự động: Student1, Student2, ...
            double marks = 1.0 + (random.nextDouble() * 9.0); // Điểm ngẫu nhiên từ 1.0 đến 10.0
            sm.addStudent(id, name, marks);
        }

        System.out.println(numberOfStudents + " students generated successfully!");

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Edit Student");
            System.out.println("4. Display Students");
            System.out.println("5. Sort Students (Quick Sort)");
            System.out.println("6. Sort Students (Bubble Sort)");
            System.out.println("7. Search for Student");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = scanner.nextDouble();
                    sm.addStudent(id, name, marks);
                    break;
                case 2:
                    sm.deleteStudent();
                    break;
                case 3:
                    System.out.print("Enter ID to edit: ");
                    String editId = scanner.nextLine();
                    System.out.print("Enter new Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new Marks: ");
                    double newMarks = scanner.nextDouble();
                    sm.editStudent(editId, newName, newMarks);
                    break;
                case 4:
                    sm.displayStudents();
                    break;
                case 5:
                    sm.quickSortWrapper();
                    break;
                case 6:
                    sm.bubbleSortWrapper();
                    break;
                case 7:
                    System.out.print("Enter ID to search: ");
                    String searchId = scanner.nextLine();
                    sm.searchStudent(searchId);
                    break;
                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
