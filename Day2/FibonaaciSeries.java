import java.util.Scanner;

public class FibonaaciSeries {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int start = -1, end = 1;

        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int next = start + end;
            System.out.print(next + " ");
            start = end;
            end = next;
        }

        scan.close();
    }
}
