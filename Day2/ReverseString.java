import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();

        char[] letters = line.toCharArray();

        int n = letters.length;

        int mid = n / 2;

        for (int i = 0; i < mid; ++i) {
            // Swap the first and last
            char temp = letters[i];
            letters[i] = letters[n - i - 1];
            letters[n - i - 1] = temp;
        }

        System.out.println(letters);

        scan.close();
    }
}
