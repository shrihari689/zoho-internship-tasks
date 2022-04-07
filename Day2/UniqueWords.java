import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class UniqueWords {
    public static void main(String[] args) {

        // Default STORAGE_MODE = 0 when the order is not required. It is faster.
        int STORAGE_MODE = 0;

        try {
            if (args.length > 0) {
                STORAGE_MODE = Integer.parseInt(args[0]);
                if (!((STORAGE_MODE == 0) || (STORAGE_MODE == 1))) {
                    throw new IllegalArgumentException("Storage Mode must be either 0 (Unordered) or 1 (Ordered)");
                }
            }

            Scanner scan = new Scanner(System.in);

            String line = scan.nextLine().toLowerCase();

            String[] uniqueWords;

            if (STORAGE_MODE == 1) {
                LinkedHashSet<String> memo = new LinkedHashSet<String>(Arrays.asList(line.split(" ")));
                uniqueWords = memo.toArray(new String[0]);
            } else {
                HashSet<String> memo = new HashSet<String>(Arrays.asList(line.split(" ")));
                uniqueWords = memo.toArray(new String[0]);
            }

            for (String word : uniqueWords) {
                System.out.println(word);
            }

            scan.close();

        } catch (NumberFormatException e) {
            System.out.println("Enter a valid number for the Storage Mode!");
        }

    }
}