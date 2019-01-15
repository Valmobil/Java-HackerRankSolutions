package hashTableOneContainsOther;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;

public class Main {
    public static void main(String[] args) {
        System.out.println(twoStrings("hello","world"));
        System.out.println(twoStrings("aardvark","apple"));
        System.out.println(twoStrings("beetroot","sandals"));
    }

    // Complete the twoStrings function below.
    private static String twoStrings(String s1, String s2) {
        String[] word = s1.split("");
        String[] find = s2.split("");

        HashSet<String> hashSet = new HashSet<>();
        hashSet.addAll(Arrays.asList(word));
        for (String s: find ) {
            if (hashSet.contains(s)) {
                return "YES";
            }
        }
        return "NO";
    }
}
