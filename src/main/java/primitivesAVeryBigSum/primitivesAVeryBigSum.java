package primitivesAVeryBigSum;

public class primitivesAVeryBigSum {

    public static void main(String[] args) {
        long[] ar = new long[]{1000000001, 1000000002, 1000000003, 1000000004, 1000000005};
        System.out.println(aVeryBigSum(ar));
    }

    // Complete the aVeryBigSum function below.
    static long aVeryBigSum(long[] ar) {
        long sum = 0L;
        for (long elem: ar             ) {
            sum+=elem;
        }
        return sum;
    }
}
