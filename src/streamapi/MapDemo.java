package streamapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Jatin", 26);
        map.put("Meghna", 22);
        map.put("Usha", 58);
        //map.put("JaiKrishan", null);

        String keyVal = "JaiKrishan";
        Integer i = map.computeIfAbsent(keyVal, (key)-> 50);

        Map<String, List<String>> map2 = new HashMap<>();
        String[] arr = {"Jatin", "Jatin","Vignesh", "Vignesh", "Vignesh", "Vignesh"};
        for(String s : arr){
            map2.computeIfAbsent(s, (asd)-> new ArrayList<>()).add(s);
            map2.compute(s, (k, v)-> v == null ? new ArrayList<>() : v).add(s);

        }
        System.out.println(map2);


        System.out.println(i);
        System.out.println(map);
    }
}
