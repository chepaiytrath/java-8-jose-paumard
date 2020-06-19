package stringio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AMergingMaps {
    public static void main(String[] args) {
        List<Person> persons = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(AMergingMaps.class.getResourceAsStream("people.txt")));
             Stream<String> stream = reader.lines()) {
            persons = stream.map(str -> {
                String[] fields = str.split(" ");
                return new Person(fields[0], Integer.parseInt(fields[1]), fields[2]);
            }).collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assert persons != null;
        //persons.forEach(System.out::println);

        List<Person> list1 = persons.subList(0, 5);
        List<Person> list2 = persons.subList(5, persons.size());

        Map<Integer, List<Person>> map1 = list1.stream().collect(Collectors.groupingBy(Person::getAge));
        Map<Integer, List<Person>> map2 = list2.stream().collect(Collectors.groupingBy(Person::getAge));

        System.out.println("-------------");
        map1.forEach((k, v) -> System.out.println(k + " " + v));
        System.out.println("-------------");
        map2.forEach((k, v) -> System.out.println(k + " " + v));
        System.out.println("-------------");

        map2.entrySet().stream().forEach(entry -> {
            map1.merge(entry.getKey(), entry.getValue(), (oldValue, newValue) -> {
                oldValue.addAll(newValue);
                return oldValue;
            });
        });
        map1.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
