import java.util.Scanner;

class Student {
    int rollNo;

    void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    int getRollNo() {
        return rollNo;
    }
}

class Test extends Student {
    int sub1, sub2;

    void setMarks(int s1, int s2) {
        sub1 = s1;
        sub2 = s2;
    }

    int getTotalMarks() {
        return sub1 + sub2;
    }
}

interface Sports {
    int sMarks = 0;
    void setSportsMarks(int sm);
}

class Result extends Test implements Sports {
    int sportsMarks;

    public void setSportsMarks(int sm) {
        sportsMarks = sm;
    }

    void display() {
        int total = getTotalMarks() + sportsMarks;
        System.out.println("Roll Number: " + getRollNo());
        System.out.println("Subject 1 Marks: " + sub1);
        System.out.println("Subject 2 Marks: " + sub2);
        System.out.println("Sports Marks: " + sportsMarks);
        System.out.println("Total Marks: " + total);
    }
}

public class ResultTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Result r = new Result();

        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();
        r.setRollNo(roll);

        System.out.print("Enter Subject 1 Marks: ");
        int m1 = sc.nextInt();

        System.out.print("Enter Subject 2 Marks: ");
        int m2 = sc.nextInt();
        r.setMarks(m1, m2);

        System.out.print("Enter Sports Marks: ");
        int sm = sc.nextInt();
        r.setSportsMarks(sm);

        System.out.println("\n--- Result ---");
        r.display();
    }
}