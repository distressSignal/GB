package Mod01.HomeWork06;

public class Cat extends Animal {
    protected static int count;
    private int runDistanceB = 200;


    public Cat(String nickname, int runDistance) {
        super(nickname, "Кошка", 0, runDistance);

        if (this.runDistance > runDistanceB) {
            this.runDistance = runDistanceB;
            System.out.println(getType() + " " + nickname + " Не может бегать на дистанции более чем на " + runDistanceB);
        }
        count++;
    }

    public static int getCount() {
        return count;
    }


    public void inf() {
        System.out.println("Кошек и котов " + getCount());

    }

    @Override
    public void run(int distance) {
        if (distance <= this.runDistance) {
            System.out.println("у " + getType() + " " + getNickname() + " получилось пробежать " + distance);
        } else {
            System.out.println(getType() + " " + getNickname() + " НЕ получилось пробежать ");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Коты не умеют плавать");
        System.out.println(getNickname() + " утонул ");

    }
}
