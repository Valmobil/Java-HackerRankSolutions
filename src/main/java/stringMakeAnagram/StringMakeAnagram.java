package stringMakeAnagram;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;

import static stringCheckForAnogram.Main.convertStringToCharHashMap;

public class StringMakeAnagram {


    public static void main(String[] args) {
        String StringOne = "akdfhhhl";
        String StringTwo = "sdaf";
        System.out.println(makeAnagram(StringOne, StringTwo));
    }

    // Complete the makeAnagram function below.
    private static int makeAnagram(String a, String b) {
        int count = 0;
        HashMap<Character, Integer> hashMapStringOne = (HashMap<Character, Integer>) convertStringToCharHashMap(a);
        HashMap<Character, Integer> hashMapStringTwo = (HashMap<Character, Integer>) convertStringToCharHashMap(b);
        HashSet<Character> hashSet = new HashSet<>();
        hashSet.addAll(hashMapStringOne.keySet());
        hashSet.addAll(hashMapStringTwo.keySet());
        for (Character key: hashSet) {
            count += Math.abs(Optional.ofNullable(hashMapStringOne.get(key)).orElse(0) - Optional.ofNullable(hashMapStringTwo.get(key)).orElse(0));
        }
        return count;
    }
}
