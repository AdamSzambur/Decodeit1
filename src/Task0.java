import java.util.Scanner;

public class Task0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] dataIn = new int[3][t];

        for (int i = 0; i < t; i++) {
            dataIn[i][0] = sc.nextInt();
            dataIn[i][1] = sc.nextInt();
            dataIn[i][2] = sc.nextInt();
        }

        for (int i = 0; i < t; i++) {
            if (dataIn[i][0]*dataIn[i][2]<=dataIn[i][1]) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}

