import java.util.HashSet;
import java.util.Iterator;

public class IterateHashSet {
    public static void main(String[] args) {

        int[] numbers = new int[] { 1, 4, 3, 9, 7, 5, 3, 1, 4 };
        HashSet<Integer> set = new HashSet<>();

        for (int item : numbers)
            set.add(item);

        Iterator<Integer> iterator = set.iterator();

        System.out.println("Using while loop");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.print("\n---------------\n");

        System.out.println("Using for loop");
        for (int item : set) {
            System.out.print(item + " ");
        }

    }
}
