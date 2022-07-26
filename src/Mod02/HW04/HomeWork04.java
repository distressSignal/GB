package Mod02.HW04;

import java.util.Arrays;

public class HomeWork04 {
    private static final int size = 100000;
    private static float[] arr = new float[size];

    public static void main(String[] args) {
        HomeWork04 hw5 = new HomeWork04();
        hw5.firstArr();
        hw5.secondArr();
    }

    private void secondArr() {

        float[] arr1 = new float[arr.length / 2];
        float[] arr2 = new float[arr.length / 2];

        unitPadding();
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, arr.length / 2);
        System.arraycopy(arr, arr.length / 2, arr2, 0, arr.length / 2);
        Thread t1 = new Thread(() -> calculate(arr1));
        Thread t2 = new Thread(() -> calculate(arr2));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
            System.arraycopy(arr1, 0, arr, 0, arr.length / 2);
            System.arraycopy(arr2, 0, arr, arr.length / 2, arr.length / 2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Время выполнения второго метода " + (System.currentTimeMillis() - a));

    }


    private void firstArr() {
        unitPadding();
        long a = System.currentTimeMillis();
        calculate(arr);
        System.out.println("Время выполнения первого метода " + (System.currentTimeMillis() - a));
    }

    private void unitPadding() {
        Arrays.fill(arr, 1.0f);
    }

    private void calculate(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

        }

    }
}
