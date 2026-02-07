import java.util.Scanner;

class QueueDemo {
    int front = 0, rear = -1, size;
    int[] queue;

    QueueDemo(int s) {
        size = s;
        queue = new int[size];
    }

    void insert(int x) {
        if (rear == size - 1) {
            System.out.println("Queue Overflow");
            return;
        }
        queue[++rear] = x;
        System.out.println("Inserted: " + x);
    }

    void delete() {
        if (front > rear) {
            System.out.println("Queue Underflow");
            return;
        }
        System.out.println("Deleted: " + queue[front++]);
    }

    void display() {
        if (front > rear) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = front; i <= rear; i++)
            System.out.print(queue[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter queue size: ");
        int n = sc.nextInt();

        QueueDemo q = new QueueDemo(n);

        int choice;
        do {
            System.out.println("\n1.Insert  2.Delete  3.Display  4.Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element: ");
                    q.insert(sc.nextInt());
                    break;
                case 2:
                    q.delete();
                    break;
                case 3:
                    q.display();
                    break;
            }
        } while (choice != 4);
    }
}