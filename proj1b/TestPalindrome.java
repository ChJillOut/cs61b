import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class TestPalindrome {

    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testisPalindrome1() {
        String word1 = "racecar" ;
        boolean expected1 = true;
        assertEquals(expected1,palindrome.isPalindrome(word1));

        String word2 = "a" ;
        boolean expected2 = true;
        assertEquals(expected2,palindrome.isPalindrome(word2));

        String word3 = "aaaA" ;
        boolean expected3 = false;
        assertEquals(expected3,palindrome.isPalindrome(word3));

        String word4 = "cat" ;
        boolean expected4 = false;
        assertEquals(expected4,palindrome.isPalindrome(word4));

    }

    @Test
    public void testisPalindrome2() {

        String word1 = "flake";
        boolean expected1 = true;
        assertEquals(expected1,palindrome.isPalindrome(word1,offByOne));

        String word2 = "ab";
        boolean expected2 = true;
        assertEquals(expected2,palindrome.isPalindrome(word2,offByOne));

        String word3 = "word";
        boolean expected3 = false;
        assertEquals(expected3,palindrome.isPalindrome(word3,offByOne));


    }
}
