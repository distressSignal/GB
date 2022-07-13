package Mod02;

import java.util.*;
import java.util.function.BiConsumer;

public class HomeWork03 {
    public static void main(String[] args) {
//        HomeWork01();
        Phonebook book = new Phonebook();
        book.add("Рома", "7455487");
        book.add("Рита", "78524");
        book.add("Антон", "24621");
        book.add("Лера", "062555");
        book.add("Алена", "110");
        book.add("Инна", "875897733");
        book.add("Инна", "8765897733");

        // ищем по имени
        book.find("Инна");
        book.find("Розп");
        book.find("Рита");

    }


    public static class Phonebook {
        HashMap<String, HashSet<String>> pb;

        public Phonebook() {
            this.pb = new HashMap<>();
        }

        public void add(String name, String phone) {
            HashSet<String> book = pb.getOrDefault(name, new HashSet<>());
            book.add(phone);
            pb.put(name, book);
        }

        public void find(String name) {
            pb.forEach(new BiConsumer<String, HashSet<String>>() {
                @Override
                public void accept(String s, HashSet<String> strings) {
                    if (s.equals(name)) {
                        System.out.printf("Контакт: %s \t  номер: %s%n", s, pb.getOrDefault(name, new HashSet<>()));
                    }
                }
            });
        }
    }

    private static void HomeWork01() {

        String[] words = new String[]{"Пушкин", "Мышка", "Часы", "Часы", "Принтер",
                "Мозайка", "Фото", "Часы", "Стакан", "Кружка",
                "Часы", "Лом", "Учитель", "Степлер", "Пушкин"};

        TreeMap<String, Integer> coincidence = new TreeMap<>();
        for (String word : words) {
            coincidence.put(word, coincidence.getOrDefault(word, 0) + 1);
        }
        coincidence.forEach(new BiConsumer<String, Integer>() {
            @Override
            public void accept(String s, Integer integer) {
                if (integer > 1) {
                    System.out.printf("Слово: %s \t \t \t Повторяется: %s раз%n", s, integer);
                }
            }
        });

    }
}