public class sortBuble {
    public static void main(String[] args) {
        int[] a = {3,2,1};
        countSwaps(a);
    }

    // Complete the countSwaps function below.
    static void countSwaps(int[] a) {
        int count = 0;
        int n = a.length;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    int tempInt = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tempInt;
                    count++;
                }
            }
        }
        System.out.println(String.format("Array is sorted in %s swaps.",count));
        System.out.println(String.format("First Element: %s", a[0]));
        System.out.println(String.format("Last Element: %s",a[a.length-1]));
    }
}
