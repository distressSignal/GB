package Mod02.HW02;

public class MyArrayDataException extends Exception{
    public MyArrayDataException( int a, int b) {
     super(String.format("по координатами [%s][%s]нету данных ",a,b));
    }

    public MyArrayDataException(int a, int b, String array) {

    System.out.println(String.format(" координатами [%s][%s] %s - не является числом  ",a,b,array));


    }
}
