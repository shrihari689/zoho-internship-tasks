import java.util.Scanner;

public class Palindrome {

    public static boolean isPalindrome(String word) {

        char[] letters = word.toCharArray();
        int n = letters.length;
        int mid = n / 2;

        for (int i = 0; i < mid; ++i) {
            char a = letters[i];
            char b = letters[n - i - 1];
            if (a != b) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();

        if (isPalindrome(word)) {
            System.out.println("Yes! " + word + " is a Palindrome!");
        } else {
            System.out.println("No! " + word + " is not a Palindrome!");
        }

        scan.close();
    }
}
