package stringIfChildStringExists;

public class Main {
    public static void main(String[] args) {
//        System.out.println(commonChild("HARRY", "SALLY"));
//        System.out.println(commonChild("AA", "BB"));
//        System.out.println(commonChild("SHINCHAN", "NOHARAAA"));
        System.out.println(commonChild("WEWOUCUIDGCGTRMEZEPXZFEJWISRSBBSYXAYDFEJJDLEBVHHKS",  "FDAGCXGKCTKWNECHMRXZWMLRYUCOCZHJRRJBOAJOQJZZVUYXIC"));
    }

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
        int length = s1.length();
        int[][] arr = new int[length + 1][length + 1];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    arr[i + 1][j + 1] = arr[i][j] + 1; }
                else {
                    arr[i + 1][j + 1] = Math.max(arr[i][j + 1], arr[i + 1][j]);

                }
            }
        }
        return arr[length][length];
    }
}
