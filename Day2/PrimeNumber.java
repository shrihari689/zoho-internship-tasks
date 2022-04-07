import java.util.Scanner;

public class PrimeNumber {

    public static boolean isPrime(int n) {

        if (n <= 1)
            return false;

        if (n == 2)
            return true;

        if (n % 2 == 0)
            return false;

        int end = (int) Math.sqrt(n);

        for (int i = 3; i <= end; ++i) {
            if (n % i == 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if (isPrime(n)) {
            System.out.println("Yeahh!! It is a Prime Number!");
        } else {
            System.out.println("Nope :( It is not a Prime Number!");
        }
        scan.close();

    }
}
