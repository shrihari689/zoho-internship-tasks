import java.util.Scanner;

public class SecondHighestNumber {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int numberOfElements = scan.nextInt();

        int[] numbers = new int[numberOfElements];

        int maximumNumber = Integer.MIN_VALUE;
        int secondMaximumNumber = Integer.MIN_VALUE;

        for (int i = 0; i < numberOfElements; ++i) {
            numbers[i] = scan.nextInt();
            if (numbers[i] > maximumNumber) {
                secondMaximumNumber = maximumNumber;
                maximumNumber = numbers[i];
            } else if (numbers[i] > secondMaximumNumber) {
                secondMaximumNumber = numbers[i];
            }
        }

        System.out.println("Maximum Number: " + maximumNumber);
        System.out.println("Second Maximum Number: " + secondMaximumNumber);

        scan.close();

    }
}
