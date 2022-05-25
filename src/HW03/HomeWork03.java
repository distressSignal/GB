package HW03;


public class HomeWork03 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        int[] arr = new int[100];
        int[] arr2 = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[][] arrS = new int[4][4];
        for (int i : array(4, 7)) {
            System.out.println(i);
        }
        mInMax(arr2);

        for (int i = 0; i < arrS.length; i++) {
            for (int j = 0; j < arrS.length; j++) {
                if (i == j || j == arrS.length - i - 1) {
                    arrS[j][i] = 1;
                }
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] < 6) {
                arr2[i] *= 2;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
    }

    public static void mInMax(int[] arr) {
        int min = arr[0];
        int max = arr[0];

        for (int i : arr) {
            if (i >= max) {
                max = i;
            }
            if (i <= min) {
                min = i;
            }

        }
        System.out.println(min);
        System.out.println(max);
    }

    public static int[] array(int len, int initialValue) {
        int[] a = new int[len];
        for (int i = 0; i < a.length; i++) {
            a[i] = initialValue;
        }
        return a;

    }


}
