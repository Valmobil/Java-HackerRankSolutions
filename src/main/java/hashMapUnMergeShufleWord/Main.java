package hashMapUnMergeShufleWord;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String input = "eggegg";
//        String input = "aeiouuoiea";
//        String input = "abcdefgabcdefg";
//        String input = "bdabaceadaedaaaeaecdeadababdbeaeeacacaba"; //answer aaaaaabaaceededecbdb

        System.out.println(reverseShuffleMerge(input));
    }

    // Complete the reverseShuffleMerge function below.
    static String reverseShuffleMerge(String s) {
        final int strLenght = s.length() / 2;
        String result = "";
        HashMap<Character, Integer> hashMap = new HashMap();
        for (char ch : s.toCharArray()) {
            if (hashMap.containsKey(ch)) {
                hashMap.replace(ch, hashMap.get(ch) + 1);
            } else {
                hashMap.put(ch, 1);
            }
        }
        hashMap.replaceAll((k, v) -> {
            return v / 2;
        });
        for (int i = s.length() - 1; i >= 0; i--) {
            HashMap<Character, Integer> hashMapTemp = new HashMap(hashMap);
            for (char ch : result.toCharArray()) {
                hashMapTemp.replace(ch, hashMapTemp.get(ch) - 1);
                ;
            }
            char curChar = s.charAt(i);
            for (int j = i - 1; j > strLenght - result.length() - 1; j--) {
                char ch = s.charAt(j);
                if (hashMapTemp.get(ch) > 0) {
                    if (curChar > ch) {
                        curChar = ch;
                        i = j;
                        hashMapTemp.replace(ch, hashMapTemp.get(ch) - 1);
                    }
                }
            }
            if (result.length() < strLenght) {
                result += curChar;
            }
        }
        return result;
    }
}
