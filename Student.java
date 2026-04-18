// ConstructorChaining 

class Student {
    int id;
    String name;

    Student() {
        this(101, "Tushar");   
        System.out.println("Default Constructor Called");
    }


    Student(int id, String name) {
        this.id = id;
        this.name = name;
        System.out.println("Parameterized Constructor Called");
    }

    void display() {
        System.out.println(id + " " + name);
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.display();
    }
}
