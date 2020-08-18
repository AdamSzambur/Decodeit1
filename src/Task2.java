import java.util.Arrays;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[] numbers = new int[a];
        for (int i = 0; i < a; i++) numbers[i] = sc.nextInt();

        for (int number : numbers) {
            System.out.println(checkNumSteps(number));
        }
    }

    private static int checkNumSteps(int number) {
        if (sortNumber(number, 1) - sortNumber(number, -1) == 0) {
            return -1;
        }

        int numSteps = 0;

        if (number == 6174) {
            return 0;
        } else {
            do {
                number = sortNumber(number, -1) - sortNumber(number, 1);
                ++numSteps;
            } while (number != 6174);
            return numSteps;
        }
    }

    private static int sortNumber(int number, int i) {
        int[] digits = Integer.toString(number).chars().map(c -> c - '0').toArray();
        if (i < 0) {
            for (int j = 0; j < digits.length; j++) {
                digits[j] *= -1;
            }
        }
        Arrays.sort(digits);
        if (i < 0) {
            for (int j = 0; j < digits.length; j++) {
                digits[j] *= -1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : digits) {
            sb.append(num);
        }
        while (sb.length() < 4) {
            if (i > 0) {
                sb.insert(0, "0");
            } else {
                sb.append("0");
            }
        }
        return Integer.parseInt(sb.toString());
    }
}
