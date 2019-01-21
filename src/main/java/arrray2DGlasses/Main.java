package arrray2DGlasses;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] arr = {{1,1,1,0,0,0},
                {0,1,0,0,0,0},
                {1,1,1,0,0,0},
                {0,0,2,4,4,0},
                {0,0,0,2,0,0},
                {0,0,1,2,4,0}};
        System.out.println(Arrays.deepToString(arr).replace("], ", "]\n"));
        System.out.println(hourglassSum(arr));
    }

    // Complete the hourglassSum function below.
    private static int hourglassSum(int[][] arr) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length-2; i++) {
            for (int j = 0; j < arr[0].length-2; j++) {
                int sum = 0;
                for (int k = 0; k < 3; k++) {
                    sum+=arr[i][j+k];
                    sum+=arr[i+2][j+k];
                }
                sum+=arr[i+1][j+1];
                System.out.println(sum);
                if (maxSum < sum) {
                    maxSum = sum;
                }
            }

        }
        return maxSum;
    }
}
