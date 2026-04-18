class QueueDemo {

    int queue[] = new int[5];
    int front = 0;
    int rear = -1;

    // Enqueue operation
    void enqueue(int x) {
        if (rear == 4) {
            System.out.println("Queue Overflow");
        } else {
            rear++;
            queue[rear] = x;
            System.out.println("Inserted element: " + x);
        }
    }

    // Dequeue operation
    void dequeue() {
        if (front > rear) {
            System.out.println("Queue Underflow");
        } else {
            System.out.println("Removed element: " + queue[front]);
            front++;
        }
    }

    // Display queue elements
    void display() {
        if (front > rear) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Queue elements are:");
            for (int i = front; i <= rear; i++) {
                System.out.println(queue[i]);
            }
        }
    }

    public static void main(String args[]) {

        QueueDemo q = new QueueDemo();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.display();

        q.dequeue();

        q.display();
    }
}