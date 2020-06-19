package streamapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ECollectorsExample {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        try (BufferedReader reader =
                     new BufferedReader(
                             new InputStreamReader(ECollectorsExample.class.getResourceAsStream("person.txt")));
             Stream<String> stream = reader.lines();) {
            stream
                    .map(
                            line -> {
                                String[] arr = line.split(" ");
                                Person p = new Person(arr[0].trim(), Integer.parseInt(arr[1]));
                                persons.add(p);
                                return p;
                            })
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Convert a list to string separated by ,
        List<String> animals = Arrays.asList("tiger", "lion", "elephant", "horse");
        String animalNames = animals.stream().collect(Collectors.joining(","));
        String animalNames2 = String.join(",", animals);

        Optional<Person> person =
                persons.stream().filter(p -> p.getAge() >= 20).min(Comparator.comparing(Person::getAge));
        System.out.println(person);

        List<String> namesList = persons.stream().filter(p -> p.getAge() >= 20).map(Person::getName).collect(Collectors.toList());
        String namesString = persons.stream().filter(p -> p.getAge() >= 20).map(Person::getName).collect(Collectors.joining(","));


        //Collectors.groupingBy(Based on what attribute you want to group, What you wanna do with the grouped up list of objects)
        Map<Integer, List<Person>> map1 =
                persons.stream().collect(Collectors.groupingBy(Person::getAge));

        Map<Integer, List<Person>> map2 =
                persons.stream().collect(Collectors.groupingBy(Person::getAge, Collectors.toList())); //Collectors.toList() is optional here

        Map<Integer, Long> map3 =
                persons.stream().collect(Collectors.groupingBy(
                        Person::getAge,
                        Collectors.counting()));

        Map<Integer, List<String>> map4 =
                persons.stream().collect(Collectors.groupingBy(
                        Person::getAge,
                        Collectors.mapping(Person::getName, Collectors.toList())));

        Map<Integer, Set<String>> map5 =
                persons.stream().collect(Collectors.groupingBy(
                        Person::getAge,
                        Collectors.mapping(Person::getName, Collectors.toCollection(TreeSet::new))));

        Map<Integer, String> map6 =
                persons.stream().collect(Collectors.groupingBy(
                        Person::getAge,
                        Collectors.mapping(Person::getName, Collectors.joining(", "))));
    }
}