package stringSpecialPalindromeAgain;

import org.junit.Assert;
import org.junit.Test;

import static stringSpecialPalindromeAgain.Main.substrCount;

public class MainTest {

    @Test
    public void testOneSameCharacters() {
        Assert.assertEquals(10,substrCount(4, "aaaa"));
    }
    @Test
    public void testTwo() {
        Assert.assertEquals(6,substrCount(4, "aaba"));
    }
}