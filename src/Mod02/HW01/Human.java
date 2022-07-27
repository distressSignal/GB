package Mod02.HW01;

public class Human implements Action {
    private String name;
    private int runDistance;
    private int jumpHeight;

    public Human(String name, int runDistance, int jumpHeight) {
        this.name = name;
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        System.out.print("Человек " + this.name + " пробежал " + this.getRunDistance());
    }

    @Override
    public void jump() {
        System.out.print("Человек " + this.name + " прыгнул на " + this.getJumpHeight());

    }

    @Override
    public int getRunDistance() {
        return this.runDistance;
    }

    @Override
    public int getJumpHeight() {
        return this.jumpHeight;
    }
}
