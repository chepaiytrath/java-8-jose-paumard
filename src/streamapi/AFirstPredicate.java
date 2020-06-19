package streamapi;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class AFirstPredicate {
    public static void main(String[] args) {
        Stream<String> s1 = Stream.of("one", "two", "three", "four", "five");
        //stream.forEach(System.out::println);
        Predicate<String> p1 = s -> s.length() > 3;
        Predicate<String> p2 = Predicate.isEqual("two");
        Predicate<String> p3 = Predicate.isEqual("three");

        Stream<String> s2 = s1.filter(p2.or(p3));           // Intermediate operation
        s2.forEach(AFirstPredicate::method);                 // Final operation
    }

    private static String method(String s) {
        System.out.println(s);
        return "123";
    }
}
