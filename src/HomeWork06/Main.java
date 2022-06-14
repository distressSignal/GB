package HomeWork06;

public class Main {
    public static void main(String[] args) {

        Animal animal = new Cat("Marfa", 10);
        Animal animal1 = new Cat("Barsic", 510);
        Animal dog = new Dog("bob", 50, 50);

        dog.run(50);
        animal1.run(50);
        dog.swim(50);

        dog.inf();
        animal1.inf();
        animal1.getCountAnimals();

    }
}
