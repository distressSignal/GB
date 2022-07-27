package Mod02.HW01;

public class Road extends Barrier {
    private int length;

    public Road(int length) {


        this.length = length;
    }

    public int getLength() {
        return length;
    }


    protected boolean moving(Action actions) {
        System.out.println("Длина дороги: " + this.length);

        actions.run();

        if (getLength() <= actions.getRunDistance()) {
            System.out.print(" успешно ");
            System.out.println();

            return true;
        } else {
            System.out.println(" безуспешно " + actions.getName() + " Выбывает");

            return false;
        }
    }
}