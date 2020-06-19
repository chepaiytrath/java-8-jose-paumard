package streamapi;

import java.util.*;
import java.util.function.Function;

public class CFlatMap {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> list2 = Arrays.asList(2, 4, 6);
        List<Integer> list3 = Arrays.asList(3, 5, 7);
        List<List<Integer>> list = Arrays.asList(list1, list2, list3);
        System.out.println(list);
        list.stream().flatMap(Collection::stream).forEach(System.out::println);
    }
}

//<R> Stream<R> map(Function<? super T, ? extends R> mapper);
//Function: R apply(T t);
//list.stream().map((t) -> { return t.size(); })
//list.stream().map(t -> { return t.size(); })
//list.stream().map(t -> t.size())
//list.stream().map(List::size)