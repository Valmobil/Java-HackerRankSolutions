package arraySumOfArrayElements;

public class Main {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(simpleArraySum(arr));
    }


    static int simpleArraySum(int[] ar) {
        int sum = 0;
        for (int i = 0; i < ar.length; i++) {
            sum += ar[i];
        }
        return sum;
    }
}