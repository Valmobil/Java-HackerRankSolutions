package arraySumRows;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        String str = "4000 30000\n" +
//                "2250 2540 180674";
//        int curTime = (int) System.currentTimeMillis() % 1000000;
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("src/arraySumRows/input/input3.txt"));
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
//        System.out.println(System.currentTimeMillis() % 1000000 - curTime);
    }
    // Complete the arrayManipulation function below.


    static long arrayManipulation(int n, int[][] queries) {
        long[] arr = new long[n + 1];
        for (int i = 0; i < queries.length; i++) {
            arr[queries[i][0]]+=queries[i][2];
            if (queries[i][1]!=arr.length-1) {
                arr[queries[i][1]+1] -= queries[i][2];
            }
            System.out.println(Arrays.toString(queries[i]));
          System.out.println(Arrays.toString(arr));
        }
        //Calculate max value
        long maxValue = Long.MIN_VALUE;
        long sumValue = 0;
        for (int i = 0; i <arr.length ; i++) {
            sumValue+= arr[i];
            maxValue = Math.max(sumValue,maxValue);
        }
        return maxValue;
    }
}
