package HomeWork06;

public abstract class Animal {
    protected static int count;
    protected int swimDistance;
    protected int runDistance;
    private String nickname;
    private String type;

    public Animal(String nickname, String type, int swimDistance, int runDistance) {
        this.nickname = nickname;
        this.type = type;
        this.swimDistance = swimDistance;
        this.runDistance = runDistance;
        count++;
    }

    public void getCountAnimals() {
        System.out.println("Всего животных " + getCountAn());
    }

    private int getCountAn() {
        return count;
    }

    public void inf() {
        System.out.println(count);
    }

    public String getNickname() {
        return nickname;
    }

    public String getType() {
        return type;
    }


    public void run(int distance) {

    }

    public abstract void swim(int distance);
}
