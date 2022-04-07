import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DuplicateCharacters {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();

        HashMap<Character, Integer> memo = new HashMap<Character, Integer>();

        ArrayList<Character> duplicates = new ArrayList<Character>();

        for (char ch : line.toCharArray()) {
            if (memo.containsKey(ch)) {
                memo.put(ch, memo.get(ch) + 1);
            } else {
                memo.put(ch, 1);
            }

            // Check whether it is the second occurence
            if (memo.get(ch) == 2) {
                duplicates.add(ch);
            }
        }

        if (duplicates.size() > 0) {
            System.out.print("Duplicate letters are: ");
            for (char item : duplicates)
                System.out.print(item + " ");
        } else {
            System.out.println("There are no duplicate letters! :D");
        }

        scan.close();
    }
}
