package Stack2;

public class main {

        public static void main(String[] args) {
            try {
                // Tạo stack với kích thước mặc định
                Test_Stack stack = new Test_Stack();

                // Thêm phần tử vào stack
                stack.push(10);
                stack.push(20);
                stack.push(30);

                // In kích thước của stack
                System.out.println("Size of stack: " + stack.size());

                // In stack hiện tại
                System.out.println("Stack: " + stack);

                // Lấy phần tử từ stack
                int poppedElement = stack.pop();
                System.out.println("Popped element: " + poppedElement);

                // In stack sau khi lấy phần tử
                System.out.println("Stack after pop: " + stack);

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

