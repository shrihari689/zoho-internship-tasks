import java.util.HashMap;
import java.util.Scanner;

public class FrequencyOfElements {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int numberOfElements = scan.nextInt();

        int[] numbers = new int[numberOfElements];

        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();

        for (int i = 0; i < numberOfElements; ++i) {
            numbers[i] = scan.nextInt();
            if (count.containsKey(numbers[i])) {
                count.put(numbers[i], count.get(numbers[i]) + 1);
            } else {
                count.put(numbers[i], 1);
            }
        }

        for (int key : count.keySet()) {
            System.out.println(String.format("%d is present %d times", key, count.get(key)));
        }

        scan.close();

    }
}
