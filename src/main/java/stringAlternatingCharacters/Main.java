package stringAlternatingCharacters;

public class Main {
    public static void main(String[] args) {
        String[] str = new String[]{"AAAA", "BBBBB", "ABABABAB", "BABABA", "AAABBB"};
        for (String st : str) {
            System.out.println(alternatingCharacters(st));
        }
    }

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
        char letterOne = s.charAt(0);
        int count = 0;
        int i = 1;
        while (i < s.length()) {
            if (s.charAt(i) == letterOne) {
                count++;
            } else {
                letterOne = s.charAt(i);
            }
            i++;
        }
        return count;
    }
}
