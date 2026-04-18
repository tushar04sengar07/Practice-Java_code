class StackDemo {

    int stack[] = new int[5];
    int top = -1;

    // Push operation
    void push(int x) {
        if (top == 4) {
            System.out.println("Stack Overflow");
        } else {
            top++;
            stack[top] = x;
            System.out.println("Inserted element: " + x);
        }
    }

    // Pop operation
    void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
        } else {
            System.out.println("Popped element: " + stack[top]);
            top--;
        }
    }

    // Display stack elements
    void display() {
        if (top == -1) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Stack elements are:");
            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i]);
            }
        }
    }

    public static void main(String args[]) {

        StackDemo s = new StackDemo();

        s.push(10);
        s.push(20);
        s.push(30);

        s.display();

        s.pop();

        s.display();
    }
}