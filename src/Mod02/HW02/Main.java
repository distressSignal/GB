package Mod02.HW02;

public class Main {
    public static void main(String[] args) {

        String[][] sNum = new String[4][4];
        sNum[0][0] = "1";
        sNum[0][1] = ",9";
        sNum[0][2] = "9";
        sNum[0][3] = "9";
        array(sNum);
    }

    private static void array(String arr[][]) {
        int result = 0;
        try {
            if (arr.length != 4) {
                throw new MyArraySizeException();
            }
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                try {

                    result += Integer.parseInt(arr[i][j]);

                } catch (NumberFormatException e) {
                    if (arr[i][j] != null) {
                        MyArrayDataException exception = new MyArrayDataException(i, j, arr[i][j]);
                        exception.printStackTrace();
                    } else {
                        MyArrayDataException exception = new MyArrayDataException(i, j);
                        exception.printStackTrace();
                    }
                }
            }
        }

        System.out.println("Результат" + result);


    }
}
