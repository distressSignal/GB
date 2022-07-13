package Mod01.HomeWork04;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[][] array = new int[10][10];
        int lastIndex = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            array[i][i]= array[i][lastIndex-i ]=1;
        }
        for (int[] ints : array) {
            System.out.println(Arrays.toString(ints));
        }

    }
}
