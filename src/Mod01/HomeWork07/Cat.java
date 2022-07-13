package Mod01.HomeWork07;

import java.util.concurrent.ThreadLocalRandom;

public class Cat {

    boolean satiety;
    private String name;

    public Cat(String name) {

        this.name = name;
        satiety = false;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void isSatietyCats() {

        if (isSatiety()) {
            System.out.println("Котик " + name + " сыт ");
        } else {
            System.out.println("Котик " + name + " голоден");
        }
    }

    public void eat(Plate plate) {
        int catEatFoodCount = ThreadLocalRandom.current().nextInt(4) + 3;
        plate.decreaseFood(catEatFoodCount);
        if (plate.isTrue()) {
            satiety = true;
//            System.out.println("Котик " + name + " съел " + catEatFoodCount + "корма");
        } else {
//            System.out.println("Котику " + name + " не хватило " + "корма");
        }

    }
}
