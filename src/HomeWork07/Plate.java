package HomeWork07;

////2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20).
public class Plate {

    private int foodCount;
    private boolean isTrue = false;

    public Plate(int foodCount) {
        this.foodCount = foodCount;
    }

    public boolean isTrue() {
        return isTrue;
    }

    @Override
    public String toString() {
        return "Plate{" + "foodCount=" + foodCount + '}';
    }

    public void printInfo() {
        System.out.println(this);
    }


    public void setFoodCount(int foodCount) {
        this.foodCount += foodCount;
    }

    public void decreaseFood(int catEatFoodCount) {

        if (foodCount >= catEatFoodCount) {
            foodCount -= catEatFoodCount;
            isTrue = true;
        } else {
            isTrue = false;

        }
    }
}
