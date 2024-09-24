package lesson7dictionary;

import java.util.*;

/**
 * Created by: Mehrojbek
 * DateTime: 16/08/24 21:34
 **/
public class HashMapTest {

    public static void main(String[] args) {

        Map<String, String> dict = new HashMap<>();

        dict.put("cat", "Mushuk");
        dict.put("hi", "Salom");
        dict.put("dog", "It");

        Set<String> strings = dict.keySet();
//        System.out.println("strings = " + strings);

        Collection<String> values = dict.values();
//        System.out.println("values = " + values);

//        System.out.println("dict = " + dict);

        String val = dict.getOrDefault("cat", "Topilmadi");
//        System.out.println("val = " + val);

        //Yo'q bo'lsa qo'shadi aks holda tegmaydi
        dict.computeIfAbsent("cat1", key -> "test23");

        //Bor bo'lsa o'zgartiradi yo'q bo'lsa tegmaydi
        dict.computeIfPresent("cat1", (key, value) -> "ggg");

        System.out.println("dict = " + dict);

//        Set<Map.Entry<String, String>> entries = dict.entrySet();


        List<Integer> integers = new ArrayList<>();
        integers.add(1);
//        integers.add(2);
        integers.add(3);

        for (Integer integer : integers) {

        }


//        for (Map.Entry<String, String> entry : entries) {
//
//        }

    }

}
