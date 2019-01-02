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
            scanner = new Scanner(new File("src/arraySumRows/input/input2.txt"));
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
        //define number of threads
        int processes = Runtime.getRuntime().availableProcessors() * 2;
        if (n<100000) {
            processes = 1;
        }
        MyThread[] threads = new MyThread[processes];

        long[][] arr = new long[processes][n + 1];
        int range = (queries.length - 1) / processes + 1;

        //Start
        for (int i = 0; i < processes; i++) {
            if (i * range < queries.length) {
                threads[i] = new MyThread(arr, i, Arrays.copyOfRange(queries, i * range, Math.min((i+1) * range,queries.length)));
                threads[i].start();
            } else {
                processes = i;
                break;
            }
        }

//      Waiting while all threads will be finished!
        for (int i = 0; i < processes; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //Summirize and find max value
        long maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < arr[0].length; i++) {
            long sumOfColumn = 0;
            for (int j = 0; j < arr.length ; j++) {
                sumOfColumn+=arr[j][i];
            }
            maxValue = Math.max(sumOfColumn,maxValue);
        }
        return maxValue;
    }

    public static class MyThread extends Thread {
        private long[][] arr;
        private int number;
        private int[][] queries;

        public MyThread(long[][] arr, int num, int[][] queries) {
            this.arr = arr;
            this.number = num;
            this.queries = queries;
        }

        public void run() {
            //Summarize values in raws
            for (int i = 0; i < this.queries.length; i++) {
                for (int j = this.queries[i][0]; j <= this.queries[i][1]; j++) {
                    this.arr[this.number][j] += this.queries[i][2];
                }
            }
        }
    }
}
