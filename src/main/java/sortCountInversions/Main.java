package sortCountInversions;

public class Main {
    public static void main(String[] args) {
        int[] arr;
        arr = new int[]{2, 1, 3, 1, 2};
        System.out.println(countInversions(arr));
    }

    // Complete the countInversions function below.
    static long countInversions(int[] arr) {
        long count = 0;
        int minValue = arr[0];
        int minIndex = 0;
        int i = 1;
        while (i < arr.length) {
            while (i > 0 && arr[i] < arr[i - 1]) {
                int temp = arr[i - 1];
                arr[i - 1] = arr[i];
                arr[i] = temp;
                count++;
                i--;
            }
            i++;
        }
        return count;
    }
}
