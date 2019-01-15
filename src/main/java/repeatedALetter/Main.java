package repeatedALetter;

import com.sun.deploy.util.StringUtils;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        String str = "a";
        System.out.println(repeatedString(str,1000000000000L));

        str = "aba";
        System.out.println(repeatedString(str,11));
    }
    // Complete the repeatedString function below.
    private static long repeatedString(String s, long n) {
//        String txt = StringUtils.repeat(s,n/(long)s.length()+1 );
//        String txt = new String(new char[n/(long)s.length()+1L]).replace("\0", s);
//        String txt = String.join("", Collections.nCopies(n, s));
//        String txt = String.format(String.format("%%%ds", n), " ").replace(" ",s);
        long repetition = n / s.length();
        long countRepetitivePart = s.chars().filter(ch -> ch == 'a').count();

        String txt = s.substring(0,(int)(n % s.length()));
        long countSecondPart = txt.chars().filter(ch -> ch == 'a').count();
        return countRepetitivePart * repetition + countSecondPart;
    }
}
