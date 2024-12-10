package ASM2_SMS;

public class StudentStack {
    private Node top;

    public StudentStack() {
        this.top = null;
    }

    // Phương thức đẩy sinh viên vào stack
    public void push(Student student) {
        Node newNode = new Node(student);
        newNode.next = top;
        top = newNode;
    }

    // Phương thức lấy sinh viên khỏi stack
    public Student pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty.");
        Student popped = top.data;
        top = top.next;
        return popped;
    }

    // Phương thức xem sinh viên ở đầu stack
    public Student peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty.");
        return top.data;
    }

    // Kiểm tra xem stack có rỗng không
    public boolean isEmpty() {
        return top == null;
    }

    // Hiển thị toàn bộ stack
    public void displayStack() {
        Node current = top;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    // Chuyển stack thành mảng để sắp xếp
    public Student[] toArray() {
        StudentStack tempStack = new StudentStack();
        int count = 0;

        while (!isEmpty()) {
            tempStack.push(pop());
            count++;
        }

        Student[] studentsArray = new Student[count];
        for (int i = 0; i < count; i++) {
            studentsArray[i] = tempStack.pop();
            push(studentsArray[i]);
        }

        return studentsArray;
    }
}

