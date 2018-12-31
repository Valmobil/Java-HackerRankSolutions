package arraySumRows;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

import static com.sun.org.apache.xerces.internal.utils.SecuritySupport.getResourceAsStream;

public class Main {


    public static void main(String[] args) {
//        String str = "4000 30000\n" +
//                "2250 2540 180674";

        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("src/arraySumRows/input/input1.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String[] nm = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] arr = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                arr[i][j] = queriesItem;
            }
        }

        System.out.println(arrayManipulation(n, arr));
    }
    // Complete the arrayManipulation function below.

    static long arrayManipulation(int n, int[][] queries) {
        long maxValue = Integer.MIN_VALUE;
        long[] arr = new long[n+1];
        //Summarize values in raws
        for (int i = 0; i < queries.length; i++) {
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                arr[j]+=queries[i][2];
                maxValue = Math.max(maxValue,arr[j]);
            }
        }
        return maxValue;
    }

}
