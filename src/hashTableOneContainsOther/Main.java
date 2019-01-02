package hashTableOneContainsOther;

import java.util.HashSet;
import java.util.Hashtable;

public class Main {
    public static void main(String[] args) {
        System.out.println(twoStrings("hello","world"));
        System.out.println(twoStrings("aardvark","apple"));
        System.out.println(twoStrings("beetroot","sandals"));
    }

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        String[] word = s1.split("");
        String[] find = s2.split("");

        HashSet<String> hashSet = new HashSet<>();
        for (String s: word) {
            hashSet.add(s);
        }
        for (String s: find ) {
            if (hashSet.contains(s)) {
                return "YES";
            }
        }
        return "NO";
    }
}
