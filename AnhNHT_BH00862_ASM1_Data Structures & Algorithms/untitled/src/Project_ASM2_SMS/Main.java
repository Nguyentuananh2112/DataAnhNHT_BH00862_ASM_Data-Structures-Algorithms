package Project_ASM2_SMS;
import java.util.Scanner;



public class Main {
    public static void main(String[] args){
        StudentManagement sm = new StudentManagement();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Student Management Menu ===");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display Students");
            System.out.println("5. Sort Students by Marks");
            System.out.println("6. Search Student");
            System.out.println("7. Undo");
            System.out.println("8. Redo");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();
                    sm.addStudent(id, name, marks);
                    break;
                case 2:
                    System.out.print("Enter ID to Edit: ");
                    id = sc.nextLine();
                    System.out.print("Enter New Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter New Marks: ");
                    marks = sc.nextDouble();
                    sm.editStudent(id, name, marks);
                    break;
                case 3:
                    System.out.print("Enter ID to Delete: ");
                    id = sc.nextLine();
                    sm.deleteStudent(id);
                    break;
                case 4:
                    sm.displayStudents();
                    break;
                case 5:
                    sm.sortStudents();
                    break;
                case 6:
                    System.out.print("Enter Name or ID to Search: ");
                    String keyword = sc.nextLine();
                    sm.searchStudent(keyword);
                    break;
                case 7:
                    sm.undo();
                    break;
                case 8:
                    sm.redo();
                    break;
                case 9:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
