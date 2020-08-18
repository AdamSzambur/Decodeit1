import java.util.Arrays;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {

        Integer[] t1 = {1,2};
        Integer[] t2 = {3,4};


        System.out.println(Arrays.toString(Stream.concat(Arrays.stream(t1), Arrays.stream(t2))
                .toArray(Integer[]::new)));

        System.out.println(Arrays.toString(t1));

    }
}
