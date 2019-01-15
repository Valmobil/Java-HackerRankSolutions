package jumpingOnCloud;

public class Main {

    public static void main(String[] args) {
        int[] arr = {0,0,0,1,0,0};
        System.out.println("Result" + jumpingOnClouds(arr));

    }

    // Complete the jumpingOnClouds function below.
    private static int jumpingOnClouds(int[] c) {
        int steps = 0;
        int startPoint = 0;
        if(c[0] == 1) {
            startPoint = 1;
        }
        for (int i = startPoint; i < c.length-1; i++) {
            if (i < c.length-2 && c[i + 2] == 0) {
                i++;
            }
            steps++;
        }
        return steps;
    }
}
