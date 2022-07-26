package Mod02.HW01;

public class Wall extends Barrier {

    private int heigth;

    public Wall(int heigth) {
        this.heigth = heigth;
    }

    public int getHeigth() {
        return heigth;
    }


    protected boolean moving(Action actions) {
        System.out.println("Высота стены:" + this.heigth);

        actions.jump();

        if (getHeigth() <= actions.getJumpHeight()) {
            System.out.print(" успешно");
            System.out.println();

            return true;
        } else {
            System.out.println(" безуспешно " + actions.getName() + " Выбывает");

            return false;
        }
    }
}