import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Task4 {

    private static int step;


    public static void main(String[] args) {
        List<String[]> connList = new ArrayList<>();
        List<String[]> queryList = new ArrayList<>();

        int steps = 0;

        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        List<Character> result = new ArrayList<>();


        // add all data to variables connList and queryList
        Pattern pattern = Pattern.compile("[BT]\\s((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\s" +
                "((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)");
        while (sc.hasNext(pattern)) {
            String[] record = sc.nextLine().split("\\s");

            if (!record[1].equals(record[2])) {
                if (record[0].equals("B")) {
                    if (!isDoubled(record, connList)) {
                        connList.add(new String[]{record[1], record[2]});
                    }
                } else {
                    if (!isDoubled(record, queryList)) {
                        queryList.add(new String[]{record[1], record[2]});
                    }
                }
            } else {
                System.out.printf("Takie same");
            }
        }

        // check all connection queries
        for (String[] queryRec : queryList) {
            System.out.println(checkQuery(queryRec, connList));
        }
    }

    private static String checkQuery(String[] queryRec, List<String[]> connList) {

        ++step;



        for (String[] connRec : connList) {
            if ((connRec[0].equals(queryRec[0]) && connRec[1].equals(queryRec[1])) || (connRec[1].equals(queryRec[0]) && connRec[0].equals(queryRec[1]))) {
                System.out.println("Poszukowany " +Arrays.toString(queryRec) + " : autualny "+ Arrays.toString(connRec));
                return "T";
            }
        }



        for (String[] connRec : connList) {
            if (connRec[0].equals(queryRec[0]) || connRec[1].equals(queryRec[0])) {
                System.out.println("Poszukowany " +Arrays.toString(queryRec) + " : autualny "+ Arrays.toString(connRec));
//                    if (connRec[0].equals(queryRec[0])) {
//                        return checkQuery(new String[]{connRec[1], queryRec[1]}, connList);
                if (connRec[1].equals(queryRec[0])) {
                    return checkQuery(new String[]{connRec[0], queryRec[1]}, connList);
                } else {
                    return checkQuery(new String[]{connRec[1], queryRec[1]}, connList);
                }
            }
        }
        return "N";
    }

    private static boolean isDoubled(String[] record, List<String[]> checkList) {
        for (String[] checkRec : checkList) {
            if ((checkRec[0].equals(record[1]) && checkRec[1].equals(record[2])) || (checkRec[1].equals(record[1]) && checkRec[0].equals(record[2]))) {
                return true;
            }
        }
        return false;
    }


}
