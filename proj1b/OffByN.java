public class OffByN implements CharacterComparator {
    public int diff;
    public OffByN(int n) {
        diff = n;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return (Math.abs(x - y) == diff);
    }
}
