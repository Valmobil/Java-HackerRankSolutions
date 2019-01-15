package arraySumOfArrayElements;

public class Main {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(simpleArraySum(arr));
    }


    private static int simpleArraySum(int[] ar) {
        int sum = 0;
        for (int i1 : ar) {
            sum += i1;
        }
        return sum;
    }
}