package arrayMinMax;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String str = "7\n" +
                "3\n" +
                "10\n" +
                "100\n" +
                "300\n" +
                "200\n" +
                "1000\n" +
                "20\n" +
                "30";
        Scanner scanner = new Scanner(str);
        int[] parameters = new int[2];
        parameters[0] = scanner.nextInt();
        parameters[1] = scanner.nextInt();
        int[] arr = new int[parameters[0]];
        int i = 0;
        while (scanner.hasNextInt()) {
            arr[i++] = scanner.nextInt();
        }
        System.out.println(maxMin(parameters[1], arr));
    }

    // Complete the maxMin function below.
    static int maxMin(int k, int[] arr) {
        k--;
        Arrays.sort(arr);
        int minDiference = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - k; i++) {
            minDiference = Math.min(arr[i + k] - arr[i], minDiference);
        }
        return minDiference;
    }
}
