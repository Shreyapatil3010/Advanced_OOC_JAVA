class Employee
{
    String name;
    String address;
    double salary;
    String jobTitle;

    Employee(String name, String address, double salary, String jobTitle)
    {
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.jobTitle = jobTitle;
    }

    double calculateBonus()
    {
        return salary * 0.10;
    }

    void performanceReport()
    {
        System.out.println(name + " is working as " + jobTitle);
    }
}

class Manager extends Employee
{
    Manager(String name, String address, double salary)
    {
        super(name, address, salary, "Manager");
    }

    void manageProject()
    {
        System.out.println(name + " is managing projects");
    }
}

class Developer extends Employee
{
    Developer(String name, String address, double salary)
    {
        super(name, address, salary, "Developer");
    }

    void manageProject()
    {
        System.out.println(name + " is developing software");
    }
}

class Programmer extends Employee
{
    Programmer(String name, String address, double salary)
    {
        super(name, address, salary, "Programmer");
    }

    void manageProject()
    {
        System.out.println(name + " is writing code");
    }
}

public class EmployeeTest
{
    public static void main(String[] args)
    {
        Manager m = new Manager("Amit", "Pune", 50000);
        Developer d = new Developer("Ravi", "Mumbai", 40000);
        Programmer p = new Programmer("Neha", "Kolhapur", 35000);

        m.performanceReport();
        System.out.println("Bonus: " + m.calculateBonus());
        m.manageProject();

        d.performanceReport();
        System.out.println("Bonus: " + d.calculateBonus());
        d.manageProject();

        p.performanceReport();
        System.out.println("Bonus: " + p.calculateBonus());
        p.manageProject();
    }
}