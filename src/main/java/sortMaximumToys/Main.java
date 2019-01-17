package sortMaximumToys;


import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String str = "7 50\n" +
                "1 12 5 111 200 1000 10";

        Scanner scanner = new Scanner(str);
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] prices = new int[n];

        String[] pricesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }

        int result = maximumToys(prices, k);
        System.out.println(result);
        scanner.close();
    }


    // Complete the maximumToys function below.
    private static int maximumToys(int[] prices, int k) {
        Arrays.sort(prices);
        int count = 0;
        for (int one : prices) {
            if (k < one) {
                break;
            }
            count++;
            k -= one;
        }
        return count;
    }
}
