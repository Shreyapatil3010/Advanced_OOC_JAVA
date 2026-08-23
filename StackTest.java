import java.util.Scanner;

interface Stack {
    void push(int data);
    void pop();
    void display();
    void overflow();
    void underflow();
}

class IntegerStack implements Stack {

    int arr[];
    int top;
    int size;

    IntegerStack(int size) {
        this.size = size;
        arr = new int[size];
        top = -1;
    }

    public void push(int data) {
        if (top == size - 1) {
            overflow();
        } else {
            arr[++top] = data;
            System.out.println("Inserted: " + data);
        }
    }

    public void pop() {
        if (top == -1) {
            underflow();
        } else {
            System.out.println("Removed: " + arr[top--]);
        }
    }

    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Stack elements:");
            for (int i = top; i >= 0; i--) {
                System.out.println(arr[i]);
            }
        }
    }

    public void overflow() {
        System.out.println("Stack Overflow");
    }

    public void underflow() {
        System.out.println("Stack Underflow");
    }
}

public class StackTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter stack size: ");
        int size = sc.nextInt();

        IntegerStack s = new IntegerStack(size);

        int choice;

        do {
            System.out.println("\n1.Push  2.Pop  3.Display  4.Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    int value = sc.nextInt();
                    s.push(value);
                    break;
                case 2:
                    s.pop();
                    break;
                case 3:
                    s.display();
                    break;
                case 4:
                    System.out.println("Exited");
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 4);
    }
}