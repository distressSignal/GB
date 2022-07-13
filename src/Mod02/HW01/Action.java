package Mod02.HW01;

public interface Action {
    public String getName();

    void run();

    void jump();

    int getRunDistance();

    int getJumpHeight();
}
