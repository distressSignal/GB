package Mod02.Part02.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
//        testArrayList();
//        testLinkedList();
//        testSet();
        testMap();
    }

    private static void testMap() {
        Map<String, String> map = new HashMap<>(400);
        map.put("Russia", "Moscow");
        map.put("Russia", "Ufa");
        map.put("France", "Paris");
        map.put("Germany", "Berlin");
        map.put("Norway", "Oslo");

        map.forEach( (key, value) ->
                System.out.printf("key: %s \t \t value: %s%n", key, value) );

//        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
//            System.out.printf("key: %s \t \t value: %s%n", stringStringEntry.getKey(), stringStringEntry.getValue());
//        }

//       for (String key : map.keySet()){
//           System.out.printf("key: %s \t \t value: %s%n", key, map.get(key));
//       }


        System.out.println(map);


    }

    private static void testSet() {
        Set<Integer> set = new HashSet<>();
        Collections.addAll(set, 1, 2, 4, 2, 1, 2, 1, 4, 6, 3, 6, 8, 9, 4, 3, 25, 56, 58, 45, 15, 26);
        System.out.println(set);
    }

    private static void testLinkedList() {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
    }

    private static void testArrayList() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add(0, "X");
        arrayList.add(1, "Y");
        arrayList.remove("C");
        System.out.println(arrayList);

//        for (String s : arrayList) {
//            System.out.print(s + "!!");
//        }

//        ListIterator<String> iterator = arrayList.listIterator();
//        while (iterator.hasNext()){
//            String s = iterator.next();
//            System.out.println("");
//        }
//        arrayList.forEach(s -> System.out.println(s+ "!!!!"));
        Object[] objects = arrayList.toArray();
        String[] strings = arrayList.toArray(new String[0]);

        Collections.addAll(arrayList, "Aaa", "D", "Bbb", "Ddd");
        Collections.shuffle(arrayList);
//        Collections.sort(arrayList);
        Collections.sort(arrayList, Comparator.comparingInt(String::length));
        Collections.reverse(arrayList);
        Collections.rotate(arrayList, 1);
        System.out.println(Collections.replaceAll(arrayList, "D", "!"));
        System.out.println(arrayList);

        List<Integer> integers = new ArrayList();
        Collections.addAll(integers, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
//        integers.get(1);

        System.out.println(integers.stream().filter(e -> e % 2 == 0).collect(Collectors.toList()));
        System.out.println(integers.stream()
                .filter(e -> e % 2 == 0)
                .map(n -> {
                    n += 10;
                    String str = "Четное число из прошлой колекции: " + n;
                    return str;
                }).collect(Collectors.toList()));

        LinkedList<Integer> list = new LinkedList<>(integers);
    }
}
