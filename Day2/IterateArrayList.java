import java.util.ArrayList;
import java.util.Iterator;

public class IterateArrayList {
    public static void main(String[] args) {

        int[] numbers = new int[] { 1, 4, 3, 9, 7, 5, 3, 1, 4 };
        ArrayList<Integer> list = new ArrayList<>();

        for (int item : numbers)
            list.add(item);

        Iterator<Integer> iterator = list.iterator();

        System.out.println("Using while loop");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.print("\n---------------\n");

        System.out.println("Using for loop without index");
        for (int item : list) {
            System.out.print(item + " ");
        }

        System.out.print("\n---------------\n");

        System.out.println("Using for loop with index");
        for (int i = 0; i < list.size(); ++i) {
            System.out.print(list.get(i) + " ");
        }
    }
}
