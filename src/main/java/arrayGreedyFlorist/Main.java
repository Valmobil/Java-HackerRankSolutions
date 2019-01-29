package arrayGreedyFlorist;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String str = "5 3\n" +
                "1 3 5 7 9";
        Scanner scanner = new Scanner(str);
        int[] parameters = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(getMinimumCost(parameters[1], arr));
    }

    // Complete the getMinimumCost function below.
    static int getMinimumCost(int k, int[] c) {
        int sum = 0;
        int[] buyer = new int[k];
        Arrays.sort(c);
        int currentBuyer = -1;
        for (int i = c.length - 1; i >= 0; i--) {
            currentBuyer++;
            if (currentBuyer >= k) {
                currentBuyer = 0;
            }
            sum += (buyer[currentBuyer] + 1)*c[i];
            buyer[currentBuyer]++;
        }
        return sum;
    }
}
