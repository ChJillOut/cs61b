import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {


    @Test
    public void testequalChars1() {
        CharacterComparator offByN = new OffByN(1);

        boolean expected1 = true;
        assertEquals(expected1,offByN.equalChars('a', 'b'));

        boolean expected2 = false;
        assertEquals(expected2,offByN.equalChars('A', 'b'));

        boolean expected3 = false;
        assertEquals(expected3,offByN.equalChars('a', 'a'));

        boolean expected4 = false;
        assertEquals(expected4,offByN.equalChars('z', 'a'));

        boolean expected5 = true;
        assertEquals(expected5,offByN.equalChars('f', 'e'));
    }

    @Test
    public void testequalChars2() {
        CharacterComparator offByN = new OffByN(2);

        boolean expected1 = true;
        assertEquals(expected1,offByN.equalChars('a', 'c'));

        boolean expected2 = false;
        assertEquals(expected2,offByN.equalChars('A', 'b'));

        boolean expected3 = false;
        assertEquals(expected3,offByN.equalChars('a', 'a'));

        boolean expected4 = false;
        assertEquals(expected4,offByN.equalChars('z', 'a'));

        boolean expected5 = true;
        assertEquals(expected5,offByN.equalChars('g', 'e'));
    }
}
