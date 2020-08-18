import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Task4 {
    public static void main(String[] args) {
        List<String[]> connList = new ArrayList<>();
        List<String> lines = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");

//        Pattern pattern = Pattern.compile("[BT]\\s((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\s" +
//                "((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)");

        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }

        for (String line : lines) {
            String[] record = line.split("\\s");
            if (!record[1].equals(record[2])) {
                if (record[0].equals("B")) {
                    connList.add(new String[]{record[1], record[2]});
                } else if (record[0].equals("T")) {
                    if (checkQuery(new String[]{record[1], record[2]}, connList)) {
                        System.out.println("T");
                    } else {
                        System.out.println("N");
                    }
                }
            }
        }
    }

    private static boolean checkQuery(String[] queryRec, List<String[]> connList) {
        for (String[] connRec : connList) {
            if ((compareIp(connRec[0], queryRec[0]) && compareIp(connRec[1], queryRec[1])) || (compareIp(connRec[1], queryRec[0]) && compareIp(connRec[0], queryRec[1]))) {
                return true;
            }
        }

        for (String[] connRec : connList) {
            if (compareIp(connRec[0], queryRec[0]) || compareIp(connRec[1], queryRec[0])) {
                List<String[]> connListTemp = new ArrayList<>(connList);
                connListTemp.remove(connRec);
                if (compareIp(connRec[1], queryRec[0])) {
                    return checkQuery(new String[]{connRec[0], queryRec[1]}, connListTemp);
                } else {
                    return checkQuery(new String[]{connRec[1], queryRec[1]}, connListTemp);
                }
            }
        }
        return false;
    }

    private static boolean compareIp(String ip1, String ip2) {
        int[] ip1array = Arrays.stream(ip1.split("\\.")).mapToInt(Integer::parseInt).toArray();
        int[] ip2array = Arrays.stream(ip2.split("\\.")).mapToInt(Integer::parseInt).toArray();
        return (ip1array[0] == ip2array[0] && ip1array[1] == ip2array[1]
                && ip1array[2] == ip2array[2] && ip1array[3] == ip2array[3]);
    }
}
