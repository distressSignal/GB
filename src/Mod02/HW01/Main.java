package Mod02.HW01;

public class Main {
    public static void main(String[] args) {
        Action[] action = new Action[3];
        action[0] = new Cat("Barsik", 366, 6);
        action[1] = new Human("Boris", 255, 2);
        action[2] = new Robot("BorisNext", 500, 4);

        Barrier[] barriers = new Barrier[2];
        barriers[0] = new Wall(4);
        barriers[1] = new Road(200);

        for (int i = 0; i < action.length; i++) {

            for (int j = 0; j < barriers.length; j++) {
                boolean result = true;
                result = barriers[j].moving(action[i]);
                if (!result) {
                    break;
                }
            }
        }

    }
}
