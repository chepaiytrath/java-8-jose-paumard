package stringio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BBuildingBiMap {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(BBuildingBiMap.class.getResourceAsStream("people.txt")));
                Stream<String> stream = reader.lines();
        ) {
            List<Person> persons = stream.map(line -> {
                String[] fields = line.split(" ");
                return new Person(fields[0], Integer.parseInt(fields[1]), fields[2]);
            }).collect(Collectors.toList());

            Map<Integer, Map<String, List<Person>>> biMap = new HashMap<>();

            persons.stream().forEach(person -> {
                biMap.computeIfAbsent(person.getAge(), HashMap::new)
                        .merge(person.getGender(), new ArrayList<>(Arrays.asList(person)), (l1, l2) -> {    //ENSURE USING NEW ARRAYlIST OTHERWISE ARRAYS.ASLIST GIVES AN UNMODIFIABLE LIST
                            l1.addAll(l2);
                            return l1;
                        });
            });

            biMap.forEach((k, v) -> System.out.println(k + " -> " + v));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
