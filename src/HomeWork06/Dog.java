package HomeWork06;

public class Dog extends Animal {
    private static int count;
    private final int runDistanceB = 500;
    private final int swDistance = 10;

    public Dog(String nickname, int swimDistance, int runDistance) {
        super(nickname, "Собака", swimDistance, runDistance);
        if (this.swimDistance > swDistance) {
            this.swimDistance = swimDistance;
            System.out.println(getType() + " " + nickname + " не может плавать на дистанции более чем на " + swDistance);
        }
        if (this.runDistance > runDistanceB) {
            this.runDistance = runDistanceB;
            System.out.println(getType() + " " + nickname + " Не может бегать на дистанции более чем на " + runDistanceB);
        }
        count++;
    }

    public static int getCount() {
        return count;
    }

    public void run(int distance) {
        if (distance <= this.runDistance) {
            System.out.println("у " + getType() + " " + getNickname() + " получилось пробежать " + distance);
        } else {
            System.out.println(getType() + " " + getNickname() + " НЕ получилось пробежать ");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= this.runDistance) {
            System.out.println("у " + getType() + " " + getNickname() + " получилось проплыть " + distance);
        } else {
            System.out.println(getType() + " " + getNickname() + " НЕ получилось проплыть ");
        }

    }

    public void inf() {
        System.out.println("Собак " + getCount());

    }
}
