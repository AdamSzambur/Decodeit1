import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        List<Character> result = new ArrayList<>();

        List<Integer[]> connList = new ArrayList<>();

        List<Integer[]> queryList = new ArrayList<>();

        Pattern pattern = Pattern.compile("[B,T]\\]");
        while (sc.hasNext(pattern)) {

            sc.nextLine();

            System.out.printf("dziala");

//            String[] record = sc.nextLine().split("\\s");
//            Integer[] ipAddress1 = Arrays.stream(record[1].split("\\."))
//                    .map(Integer::parseInt)
//                    .toArray(Integer[]::new);
//            Integer[] ipAddress2 = Arrays.stream(record[2].split("\\."))
//                    .map(Integer::parseInt)
//                    .toArray(Integer[]::new);
//
//            if (record[0].equals("B")) {
//                connList.add(Stream.concat(Arrays.stream(ipAddress1), Arrays.stream(ipAddress2))
//                        .toArray(Integer[]::new));
//            } else {
    //                queryList.add(Stream.concat(Arrays.stream(ipAddress1), Arrays.stream(ipAddress2))
//                        .toArray(Integer[]::new));
//            }
        }
    }



}
