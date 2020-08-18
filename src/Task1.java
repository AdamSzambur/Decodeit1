import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int s = sc.nextInt();

        int skyNumbers;
        int earthNumbers;
        int restRow= 0;
        // count sky possibility numbers
        skyNumbers = (int)Math.pow(2,r);
        // count earth possibility numbers
        int rowNum = s/r;
        if (rowNum>8) {
            rowNum = 8;
        }

        if (r!=1){
            // count rest
            if (rowNum <= 8) {
                restRow = s % r;
            }
            if (rowNum == 8) {
                restRow = 0;
            }

            earthNumbers = skyNumbers * rowNum;
            if (restRow > 0) {
                earthNumbers += Math.pow(2, restRow);
            }
        } else {
            skyNumbers = 2;
            earthNumbers = rowNum-1 + 2;
        }

//        System.out.println("rowNum : "+rowNum);
//        System.out.println("restRow : "+restRow);
        System.out.println(skyNumbers * earthNumbers);
    }
}
