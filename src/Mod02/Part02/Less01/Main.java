package Mod02.Part02.Less01;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        Duck duck = new Duck();
        Plane plane = new Plane();
        Wolf wolf = new Wolf();

        Runner[] runners = {cat, dog, duck};
        Flying [] flyings ={duck,plane};

        dpFly(plane);
        dpFly(duck);


    }

    private static void  dpFly(Flying f){
        System.out.println("Подготовка к полету");
        f.fly();
        System.out.println("Завершение полета");
    }
}
