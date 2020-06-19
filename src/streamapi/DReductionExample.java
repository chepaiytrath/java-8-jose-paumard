package streamapi;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class DReductionExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10);
        Integer red = list.stream().reduce(0, Integer::sum);
        //System.out.println(red);


        List<Integer> list2 = Arrays.asList(-10, -5);   //-10:0=0, 0:-5=0 => Max in stream = 0
        Integer red2 = list2.stream().reduce(0, Integer::max);
        //System.out.println(red2);

        List<Integer> list3 = Arrays.asList(-10, -5);   //If list is empty, output is Optional.empty
        Optional<Integer> red3 = list3.stream().reduce(Integer::max);
        System.out.println(red3);
    }
}
