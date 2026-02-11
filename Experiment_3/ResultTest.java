class Student
{
    int rollNo;

    void setRollNo(int rollNo)
    {
        this.rollNo = rollNo;
    }
}

class Test extends Student
{
    int sub1;
    int sub2;

    void setMarks(int sub1, int sub2)
    {
        this.sub1 = sub1;
        this.sub2 = sub2;
    }
}

class Result extends Test
{
    void displayResult()
    {
        int total = sub1 + sub2;
        double percentage = total / 2.0;

        System.out.println("Roll No: " + rollNo);
        System.out.println("Subject 1: " + sub1);
        System.out.println("Subject 2: " + sub2);
        System.out.println("Total Marks: " + total);
        System.out.println("Percentage: " + percentage + "%");
    }
}

public class ResultTest
{
    public static void main(String[] args)
    {
        Result r = new Result();
        r.setRollNo(101);
        r.setMarks(45, 55);
        r.displayResult();
    }
}