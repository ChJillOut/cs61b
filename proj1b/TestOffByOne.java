import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    /*
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    Uncomment this class once you've created your CharacterComparator interface and OffByOne class. **/
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testequalChars() {

        boolean expected1 = true;
        assertEquals(expected1,offByOne.equalChars('a', 'b'));

        boolean expected2 = false;
        assertEquals(expected2,offByOne.equalChars('A', 'b'));

        boolean expected3 = false;
        assertEquals(expected3,offByOne.equalChars('a', 'a'));

        boolean expected4 = false;
        assertEquals(expected4,offByOne.equalChars('z', 'a'));

        boolean expected5 = true;
        assertEquals(expected5,offByOne.equalChars('f', 'e'));
    }


}
