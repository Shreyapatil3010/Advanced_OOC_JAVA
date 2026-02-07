public class EmployeeTest {
    public static void main(String[] args) {

        Employee emp1 = new Employee("Shreya", "Patil", 20000);
        Employee emp2 = new Employee("Radha", "Patil", 25000);

        System.out.println("Yearly Salary Before Raise:");
        System.out.println(emp1.getFirstName() + " " + emp1.getLastName() +
                ": " + emp1.getYearlySalary());
        System.out.println(emp2.getFirstName() + " " + emp2.getLastName() +
                ": " + emp2.getYearlySalary());

        emp1.giveRaise();
        emp2.giveRaise();

        System.out.println("\nYearly Salary After 10% Raise:");
        System.out.println(emp1.getFirstName() + " " + emp1.getLastName() +
                ": " + emp1.getYearlySalary());
        System.out.println(emp2.getFirstName() + " " + emp2.getLastName() +
                ": " + emp2.getYearlySalary());
    }
}