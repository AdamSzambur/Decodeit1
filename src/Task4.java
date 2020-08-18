import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Task4 {
    public static void main(String[] args) {
        List<String[]> connList = new ArrayList<>();
        List<String> lines = new ArrayList<>();
//        String newLine;

        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");

        Pattern pattern = Pattern.compile("[BT]\\s((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\s" +
                "((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)");

//        while (sc.hasNext(pattern) && !(newLine = sc.nextLine()).equals("")) {
//            lines.add(newLine);
//        }
        while (sc.hasNext(pattern)) {
            lines.add(sc.nextLine());
        }

        for (String line : lines) {
            String[] record = line.split("\\s");
            if (!record[1].equals(record[2])) {
                if (record[0].equals("B")) {
                    if (!checkQuery(new String[]{record[1], record[2]}, connList)) {
                        connList.add(new String[]{record[1], record[2]});
                    }
                } else if (record[0].equals("T")){
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
            if ((connRec[0].equals(queryRec[0]) && connRec[1].equals(queryRec[1])) || (connRec[1].equals(queryRec[0]) && connRec[0].equals(queryRec[1]))) {
                return true;
            }
        }

        for (String[] connRec : connList) {
            if (connRec[0].equals(queryRec[0]) || connRec[1].equals(queryRec[0])) {
                List<String[]> connListTemp = new ArrayList<>(connList);
                connListTemp.remove(connRec);
                if (connRec[1].equals(queryRec[0])) {
                    return checkQuery(new String[]{connRec[0], queryRec[1]}, connListTemp);
                } else {
                    return checkQuery(new String[]{connRec[1], queryRec[1]}, connListTemp);
                }
            }
        }
        return false;
    }
}
