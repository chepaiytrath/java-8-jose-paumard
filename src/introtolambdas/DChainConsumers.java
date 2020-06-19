package introtolambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class DChainConsumers {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("one", "two", "three", "four", "five");
        List<String> result = new ArrayList<>();
        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = result::add;
        list.forEach(c1.andThen(c2));
        System.out.println(result.size());
    }
}
