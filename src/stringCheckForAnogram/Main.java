package stringCheckForAnogram;

import javax.swing.*;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println(sherlockAndAnagrams("abba"));
        System.out.println(sherlockAndAnagrams("abcd"));
    }

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int count = 0;
        Hashtable<String, String> hashtable = new Hashtable();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j <= s.length() - 1; j++) {
                if (i + j > s.length()) break;
                hashtable.put(i + "_" + (i + j - 1), s.substring(i, i + j));
            }
        }
        String valueMaster = "";
        String keyMaster = "";
        while (hashtable.size() > 0) {
            int step = 0;
            for (String key : hashtable.keySet()) {
                if (step == 0) {
                    valueMaster = hashtable.get(key);
                    keyMaster = key;
                    step = 1;
                } else {
                    if (ifAnogram(valueMaster, hashtable.get(key))) {
                        count++;
                    }
                }
            }
            hashtable.remove(keyMaster);
        }
        return count;
    }

    private static boolean ifAnogram(String s1, String s2) {
        //Convert String to charHashMap
        if (s1.length() != s2.length()) {
            return false;
        }
        HashMap<Character, Integer> hashMapS1 = convertStringToCharHashMap(s1);
        HashMap<Character, Integer> hashMapS2 = convertStringToCharHashMap(s2);
        for (Character key : hashMapS1.keySet()) {
            if (hashMapS1.get(key) != hashMapS2.get(key)) {
                return false;
            }
        }
        return true;
    }

    private static HashMap convertStringToCharHashMap(String s2) {
        HashMap<Character, Integer> hashMap = new HashMap();
        for (int i = 0; i < s2.length(); i++) {
            if (hashMap.containsKey(s2.charAt(i))) {
                hashMap.put(s2.charAt(i), hashMap.get(s2.charAt(i)) + 1);
            } else {
                hashMap.put(s2.charAt(i), 1);
            }
        }
        return hashMap;
    }

}
