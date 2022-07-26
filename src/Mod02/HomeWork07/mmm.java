package Mod02.HomeWork07;

public class mmm {
    public static void main(String[] args) {
        String message = "/pm nik soobshenie i vtorie slovo";
        String nik = message.split("\\s+")[1];



        int a = message.indexOf(nik);
        String result = message.substring(a+nik.length()).trim();
//                    String result = String.valueOf(message.startsWith(nik));
        System.out.println(message);
        System.out.println("СООБЩЕНИЕ ИЗ РИДЕРА   " + result);
        System.out.println("СООБЩЕНИЕ ИЗ РИДЕРА   " + nik);
        System.out.println("СООБЩЕНИЕ ИЗ РИДЕРА   " + a);
    }
}
