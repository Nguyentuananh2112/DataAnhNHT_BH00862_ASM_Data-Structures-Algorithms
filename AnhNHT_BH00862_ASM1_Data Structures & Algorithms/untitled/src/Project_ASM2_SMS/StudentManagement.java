package Project_ASM2_SMS;

import java.util.*;


public class StudentManagement {
    private List<Student> students = new ArrayList<>();
    private Stack<String> undoStack = new Stack<>();
    private Stack<String> redoStack = new Stack<>();

    // Thêm sinh viên
    public void addStudent(String id, String name, double marks) {
        students.add(new Student(id, name, marks));
        undoStack.push("ADD " + id);
        redoStack.clear(); // Xóa stack redo khi có thao tác mới
        System.out.println("Student added: " + name);
    }

    // Sửa thông tin sinh viên
    public void editStudent(String id, String newName, double newMarks) {
        for (Student s : students) {
            if (s.getId().equals(id)) {
                undoStack.push("EDIT " + id + " " + s.getName() + " " + s.getMarks());
                s.setName(newName);
                s.setMarks(newMarks);
                redoStack.clear();
                System.out.println("Student edited: " + id);
                return;
            }
        }
        System.out.println("Error: Student not found.");
    }

    // Xóa sinh viên
    public void deleteStudent(String id) {
        for (Student s : students) {
            if (s.getId().equals(id)) {
                undoStack.push("DELETE " + id + " " + s.getName() + " " + s.getMarks());
                students.remove(s);
                redoStack.clear();
                System.out.println("Student deleted: " + id);
                return;
            }
        }
        System.out.println("Error: Student not found.");
    }

    // Hiển thị tất cả sinh viên
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    // Sắp xếp sinh viên theo điểm số giảm dần
    public void sortStudents() {
        students.sort((a, b) -> Double.compare(b.getMarks(), a.getMarks()));
        System.out.println("Students sorted by marks.");
    }

    // Tìm kiếm sinh viên theo tên hoặc ID
    public void searchStudent(String keyword) {
        boolean found = false;
        for (Student s : students) {
            if (s.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                    s.getId().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(s);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students found for the keyword: " + keyword);
        }
    }

    // Undo thao tác cuối cùng
    public void undo() {
        if (!undoStack.isEmpty()) {
            String action = undoStack.pop();
            redoStack.push(action);
            String[] parts = action.split(" ");

            switch (parts[0]) {
                case "ADD":
                    students.removeIf(s -> s.getId().equals(parts[1]));
                    break;
                case "EDIT":
                    for (Student s : students) {
                        if (s.getId().equals(parts[1])) {
                            s.setName(parts[2]);
                            s.setMarks(Double.parseDouble(parts[3]));
                            break;
                        }
                    }
                    break;
                case "DELETE":
                    students.add(new Student(parts[1], parts[2], Double.parseDouble(parts[3])));
                    break;
            }
            System.out.println("Undo completed.");
        } else {
            System.out.println("No actions to undo.");
        }
    }

    // Redo thao tác đã undo
    public void redo() {
        if (!redoStack.isEmpty()) {
            String action = redoStack.pop();
            undoStack.push(action);
            String[] parts = action.split(" ");

            switch (parts[0]) {
                case "ADD":
                    students.add(new Student(parts[1], "", 0));  // Thêm sinh viên mặc định
                    break;
                case "EDIT":
                    for (Student s : students) {
                        if (s.getId().equals(parts[1])) {
                            s.setName(parts[2]);
                            s.setMarks(Double.parseDouble(parts[3]));
                            break;
                        }
                    }
                    break;
                case "DELETE":
                    students.removeIf(s -> s.getId().equals(parts[1]));
                    break;
            }
            System.out.println("Redo completed.");
        } else {
            System.out.println("No actions to redo.");
        }
    }
}
