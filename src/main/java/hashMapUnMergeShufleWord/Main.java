package hashMapUnMergeShufleWord;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String input = "aeiouuoiea";
        //Expected result
        System.out.println("eaid");
        System.out.println(reverseShuffleMerge(input));
    }

    // Complete the reverseShuffleMerge function below.
    static String reverseShuffleMerge(String s) {
        final int strLenght = s.length() / 2;
        StringBuilder result = new StringBuilder();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (hashMap.containsKey(ch)) {
                hashMap.replace(ch, hashMap.get(ch) + 1);
            } else {
                hashMap.put(ch, 1);
            }
        }
        hashMap.replaceAll((k, v) -> v / 2);

        HashMap<Character, Integer> hashMapCurrentQty = new HashMap<>(hashMap);
        HashMap<Character, Integer> hashMapSkipped = new HashMap<>(hashMap);
        int lastIndex;
        for (int i = s.length() - 1; i >= 0; i--) {
            lastIndex = i;

            //calculate next letter
            HashMap<Character, Integer> hashMapSkippedCurrent = new HashMap<>();
            char curChar = s.charAt(i);
            while (hashMapCurrentQty.get(curChar) < 1 && i > 0) {
                hashMapReplaceByKey(hashMapSkippedCurrent, curChar, 1);
                i--;
                curChar = s.charAt(i);
            }
            hashMapReplaceByKey(hashMapSkippedCurrent, curChar, 0);

            //Enter if letter can be skipped
            if (hashMapSkipped.get(curChar) - hashMapSkippedCurrent.get(curChar) > 0) {
                hashMapReplaceByKey(hashMapSkippedCurrent, curChar, 1);
                for (int j = i - 1; j > strLenght - result.length() - 1; j--) {
                    char ch = s.charAt(j);
                    hashMapReplaceByKey(hashMapSkippedCurrent, ch, 0);
                    if (hashMapCurrentQty.get(ch) > 0) {
                        if (ch < curChar) {
                            curChar = ch;
                            i = j;
                            //can be used or skipped
                            if (hashMapSkipped.get(ch) - hashMapSkippedCurrent.get(ch) < 1) {
                                break;
                            }

                        } else {
                            if (hashMapSkipped.get(ch) - hashMapSkippedCurrent.get(ch) < 1) {
                                break;
                            }
                        }
                    }
                    hashMapReplaceByKey(hashMapSkippedCurrent, s.charAt(j), 1);
                }
            }
            if (result.length() < strLenght) {
                result.append(curChar);
                hashMapReplaceByKey(hashMapCurrentQty, curChar, -1);
                hashMapReplaceByKey(hashMapSkipped, curChar, 1);
                for (int j = lastIndex; j >= i; j--) {
                    hashMapReplaceByKey(hashMapSkipped, s.charAt(j), -1);
                }
            }
        }
        return result.toString();
    }

    private static void hashMapReplaceByKey(HashMap<Character, Integer> hashMap, char ch, int delta) {
        if (hashMap.containsKey(ch)) {
            hashMap.replace(ch, hashMap.get(ch) + delta);
        } else {
            hashMap.put(ch, delta);
        }
    }
}
