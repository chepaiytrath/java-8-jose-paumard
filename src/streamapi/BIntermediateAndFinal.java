package streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class BIntermediateAndFinal {
    public static void main(String[] args) {
        Stream<String> s1 = Stream.of("one", "two", "three", "four", "five");
        Predicate<String> p1 = Predicate.isEqual("two");
        Predicate<String> p2 = Predicate.isEqual("three");
        List<String> list = new ArrayList<>();

        Stream<String> s2 = s1.peek(System.out::println).filter(p1.or(p2)).peek(list::add);           // Last Intermediate operation
        s1.peek(System.out::println).filter(p1.or(p2)).forEach(list::add);        // Last Final operation : Triggers actual processing of the data from the stream
        System.out.println(list.size());
    }
}
//Stream<T> peek(Consumer<? super T> action);
//Consumer:void accept(T t);
//s1.peek((s) -> { System.out.println(s) })
//s1.peek((s) -> System.out.println(s))
//s1.peek(s -> System.out.println(s))
//s1.peek(System.out::println)