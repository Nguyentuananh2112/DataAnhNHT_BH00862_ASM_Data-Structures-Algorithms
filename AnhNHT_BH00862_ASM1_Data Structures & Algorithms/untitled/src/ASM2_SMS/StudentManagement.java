package ASM2_SMS;

public class StudentManagement {
    private StudentStack studentStack;

    public StudentManagement() {
        studentStack = new StudentStack();
    }

    // Thêm sinh viên
    public void addStudent(String id, String name, double marks) {
        Student student = new Student(id, name, marks);
        studentStack.push(student);
    }

    // Xóa sinh viên
    public void deleteStudent() {
        if (!studentStack.isEmpty()) {
            studentStack.pop();
            System.out.println("Student removed from the stack.");
        } else {
            System.out.println("Stack is empty, nothing to delete.");
        }
    }

    // Sửa sinh viên
    public void editStudent(String id, String newName, double newMarks) {
        StudentStack tempStack = new StudentStack();
        boolean found = false;

        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            if (student.getId().equals(id)) {
                student.setName(newName);
                student.setMarks(newMarks);
                found = true;
            }
            tempStack.push(student);
        }

        while (!tempStack.isEmpty()) {
            studentStack.push(tempStack.pop());
        }

        if (found) {
            System.out.println("Student updated.");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Hiển thị danh sách sinh viên
    public void displayStudents() {
        System.out.println("Students in the stack:");
        studentStack.displayStack();
    }

    // Quick Sort Wrapper
    public void quickSortWrapper() {
        // Chuyển đổi stack thành mảng
        Student[] studentsArray = studentStack.toArray();

        // Thực hiện Quick Sort trên mảng
        long startTime = System.nanoTime();
        quickSortStudents(studentsArray, 0, studentsArray.length - 1);
        long endTime = System.nanoTime();

        // Xây dựng lại stack từ mảng đã được sắp xếp
        rebuildStack(studentsArray);

        System.out.println("Quick Sort completed.");
        System.out.println("Students sorted by marks using QuickSort:");
        System.out.println("QuickSort time: " + (endTime - startTime) + " nanoseconds");
    }

    // Phương thức QuickSort
    private void quickSortStudents(Student[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSortStudents(array, low, pivotIndex - 1);
            quickSortStudents(array, pivotIndex + 1, high);
        }
    }

    // Phương thức phân chia QuickSort
    private int partition(Student[] array, int low, int high) {
        Student pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j].getMarks() >= pivot.getMarks()) { // Sort descending
                i++;
                Student temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        Student temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    // Xây dựng lại stack từ mảng
    private void rebuildStack(Student[] studentsArray) {
        studentStack = new StudentStack();
        for (Student student : studentsArray) {
            studentStack.push(student);
        }
    }

    // Tìm kiếm sinh viên theo ID
    public void searchStudent(String id) {
        StudentStack tempStack = new StudentStack();
        boolean found = false;

        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            if (student.getId().equals(id)) {
                System.out.println("Student found: " + student);
                found = true;
            }
            tempStack.push(student);
        }

        while (!tempStack.isEmpty()) {
            studentStack.push(tempStack.pop());
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    // Bubble Sort Wrapper
    public void bubbleSortWrapper() {
        // Chuyển đổi stack thành mảng
        Student[] studentsArray = studentStack.toArray();

        // Thực hiện Bubble Sort trên mảng
        long startTime = System.nanoTime();
        bubbleSort(studentsArray);
        long endTime = System.nanoTime();

        // Xây dựng lại stack từ mảng đã được sắp xếp
        rebuildStack(studentsArray);

        System.out.println("Bubble Sort completed.");
        System.out.println("Students sorted by marks using BubbleSort:");
        System.out.println("BubbleSort time: " + (endTime - startTime) + " nanoseconds");
    }

    // Phương thức Bubble Sort
    private void bubbleSort(Student[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].getMarks() < array[j + 1].getMarks()) {
                    Student temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
