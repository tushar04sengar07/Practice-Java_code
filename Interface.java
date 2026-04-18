// interface
interface Animal {

    void sound();  // method without body
}

// class implementing interface
class Dog implements Animal {

    public void sound() {
        System.out.println("Dog barks");
    }
}

class Interface {

    public static void main(String[] args) {

        Dog d = new Dog();
        d.sound();
    }
}