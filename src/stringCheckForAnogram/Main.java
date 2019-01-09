package stringCheckForAnogram;

import javax.swing.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(sherlockAndAnagrams("abba"));
        System.out.println(sherlockAndAnagrams("abcd"));
    }

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int count = 0;
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j <= s.length() - 1; j++) {
                if (i + j > s.length()) break;
                list.add(s.substring(i, i + j));
            }
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (ifAnogram(list.get(i), list.get(j))) {
                    count++;
                }
            }
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
            if (hashMapS1.get(key).equals(hashMapS2.get(key))) {
                return false;
            }
        }
        return true;
    }

    private static HashMap convertStringToCharHashMap(String s2) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
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
