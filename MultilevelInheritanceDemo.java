class Person {
    String name;
    int age;
    int id;

    Person(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
        System.out.println("Person constructor called: " + name + ", " + age + ", " + id);
    }

    void displayInfo() {
        System.out.println("Person Info: Name=" + name + ", Age=" + age + ", ID=" + id);
    }
}

class Employee extends Person {
    double salary;
    String department;
    int id;

    Employee(String name, int age, int personId, double salary, String department, int empId) {
        super(name, age, personId);
        this.salary = salary;
        this.department = department;
        this.id = empId;
        System.out.println("Employee constructor called: " + salary + ", " + department + ", " + empId);
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("Employee Info: Salary=" + salary + ", Department=" + department + ", EmpID=" + id);
    }
}

class Manager extends Employee {
    double bonus;
    int teamSize;

    Manager(String name, int age, int personId, double salary, String department, int empId, double bonus, int teamSize) {
        super(name, age, personId, salary, department, empId);
        this.bonus = bonus;
        this.teamSize = teamSize;
        System.out.println("Manager constructor called: " + bonus + ", " + teamSize);
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("Manager Info: Bonus=" + bonus + ", Team Size=" + teamSize);
        System.out.println("Accessing shadowed parent ID using super: " + super.id);
        System.out.println("Current class ID: " + this.id);
    }
}

public class MultilevelInheritanceDemo {
    public static void main(String[] args) {
        System.out.println("Creating Manager object:");
        Manager mgr = new Manager("John Doe", 45, 1001, 75000.0, "IT", 2001, 15000.0, 10);
        System.out.println("\nCalling displayInfo():");
        mgr.displayInfo();
    }
}