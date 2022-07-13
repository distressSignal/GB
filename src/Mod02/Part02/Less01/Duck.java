package Mod02.Part02.Less01;

public class Duck extends  Animal implements Flying,Runner,Jumper{
    private String name;

    public Duck(String name) {
        this.name = name;
    }

    public Duck() {
    }

    public String getName() {
        return name;
    }

    @Override
    public void fly() {
System.out.println("Утка полетела");
    }

    @Override
    public void jump() {

    }

    @Override
    public void run() {

    }
}
