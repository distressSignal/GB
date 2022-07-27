package Mod02.HW02;

public class MyArraySizeException extends Exception {
    public MyArraySizeException() {
        super(String.format("размер массива не соответствует 4 на 4"));
    }
}
