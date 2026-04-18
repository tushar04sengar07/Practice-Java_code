// Aggregation code

class Teacher {
    String name;

    Teacher(String name) {
        this.name = name;
    }
}

class Department {
    String deptName;
    Teacher teacher;   // Aggregation

    Department(String deptName, Teacher teacher) {
        this.deptName = deptName;
        this.teacher = teacher;
    }

    void display() {
        System.out.println("Department: " + deptName);
        System.out.println("Teacher: " + teacher.name);
    }

    public static void main(String[] args) {
        Teacher t1 = new Teacher("Rahul");  // Teacher exists independently
        Department d1 = new Department("Computer Science", t1);
        d1.display();
    }
}
