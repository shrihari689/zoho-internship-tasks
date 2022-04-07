import java.util.Scanner;

public class CountWords {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String line = scan.nextLine().strip();

        int wordsCount = line.split(" ").length;

        System.out.println("There are " + wordsCount + " words!");

        scan.close();
    }
}
