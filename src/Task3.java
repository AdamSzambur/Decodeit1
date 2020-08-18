import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int[] n = new int[t];
        String[] data = new String[t];
        String[] result = new String[t];

        for (int i = 0; i < t; i++) {
            n[i] = sc.nextInt();
            sc.nextLine();
            data[i] = sc.nextLine();
        }

        for (int i=0; i<t; i++) {
            System.out.println(decodePassword(data[i],n[i]));
        }
    }

    private static String decodePassword(String datum, int i) {
        StringBuilder result = new StringBuilder();
        String[] codedPassword = new String[i];
        int startPos = 0;
        for (int j=0; j<i; j++) {
            codedPassword[j] = datum.substring(startPos, startPos+4);
            startPos += 4;
        }
        for (int j=0; j<i; j++) {
            result.append((char) (Integer.parseInt(codedPassword[j].substring(0, 1) + codedPassword[j].substring(2, 3)) +
                    Integer.parseInt(codedPassword[j].substring(1, 2) + codedPassword[j].substring(3, 4))));
        }
        return result.toString();
    }
}
