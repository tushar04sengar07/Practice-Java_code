// Compostiton

class Engine {
    String type;

    Engine(String type) {
        this.type = type;
    }

    void showEngine() {
        System.out.println("Engine Type: " + type);
    }
}

class Car {
    String brand;
    Engine engine;   // Composition

    Car(String brand, String engineType) {
        this.brand = brand;
        engine = new Engine(engineType);
    }

    void displayCar() {
        System.out.println("Car Brand: " + brand);
        engine.showEngine();
    }

    public static void main(String[] args) {
        Car c1 = new Car("BMW", "Petrol");
        c1.displayCar();
    }
}
