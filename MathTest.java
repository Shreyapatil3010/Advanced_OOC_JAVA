import java.util.Scanner;
import MathOperations.FloorOperation;
import MathOperations.CeilOperation;
import MathOperations.RoundOperation;

public class MathTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        double num = sc.nextDouble();

        FloorOperation f = new FloorOperation();
        CeilOperation c = new CeilOperation();
        RoundOperation r = new RoundOperation();

        System.out.println("Floor Value: " + f.getFloor(num));
        System.out.println("Ceil Value: " + c.getCeil(num));
        System.out.println("Round Value: " + r.getRound(num));
    }
}