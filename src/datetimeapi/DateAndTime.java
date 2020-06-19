package datetimeapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DateAndTime {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        DateAndTime.class.getResourceAsStream("people.txt")));
             Stream<String> stream = reader.lines();
        ) {
            stream.map(line -> {
                String[] arr = line.split(" ");
                String name = arr[0];
                int year = Integer.parseInt(arr[1]);
                Month month = Month.of(Integer.parseInt(arr[2]));
                int day = Integer.parseInt(arr[3]);
                LocalDate dob = LocalDate.of(year, month, day);
                Person person = new Person(name, dob);
                persons.add(person);
                return person;
            }).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        LocalDate now = LocalDate.of(2014, Month.MARCH, 12);
        persons.stream().forEach(person -> {
            Period period = Period.between(person.dob, now);
            System.out.println(person.getName() + " was born " +
                    period.get(ChronoUnit.YEARS) + " years and " +
                    period.get(ChronoUnit.MONTHS)+ " months ago." +
                    "["+person.getDob().until(now, ChronoUnit.MONTHS)+"]");
        });
    }
}
