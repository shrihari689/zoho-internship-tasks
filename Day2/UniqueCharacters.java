import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;

public class UniqueCharacters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String line = scan.nextLine();

        HashMap<Character, Integer> memo = new HashMap<Character, Integer>();

        HashSet<Character> uniqueCharacters = new HashSet<Character>();

        for (char ch : line.toCharArray()) {
            if (memo.containsKey(ch)) {
                memo.put(ch, memo.get(ch) + 1);
            } else {
                memo.put(ch, 1);
            }

            // Check exactly it occurs once
            if (memo.get(ch) == 1) {
                uniqueCharacters.add(ch);
            } else {
                uniqueCharacters.remove(ch);
            }
        }

        if (uniqueCharacters.size() > 0) {
            System.out.print("Unique letters are: ");
            for (char item : uniqueCharacters)
                System.out.print(item + " ");
        } else {
            System.out.println("There are no Unique letters! :D");
        }
        scan.close();
    }
}
