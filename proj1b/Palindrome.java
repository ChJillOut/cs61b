public class Palindrome {
    public static Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new LinkedListDeque();
        for (int i = 0; i<word.length(); i += 1) {
            char a_char =word.charAt(i);
            deque.addLast(a_char);
        }
        return deque;
    }

    public boolean isPalindrome(String word) {
        Deque d = wordToDeque(word);
        if (d.size() == 0 || d.size() == 1) {
            return true;
        } else {
            if (d.removeFirst() == d.removeLast()) {
                return isPalindrome(dequeToString(d));
            } else {
                return false;
            }
        }
    }

    private static String dequeToString(Deque d) {
        String word = "";
        while (d.size() > 0) {
            word += d.removeFirst();
        }
        return word;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque <Character> d = wordToDeque(word);
        if (d.size() == 0 || d.size() == 1) {
            return true;
        } else {
            if (cc.equalChars(d.removeFirst(), d.removeLast())) {
                return isPalindrome(dequeToString(d),cc);
            } else {
                return false;
            }
        }
    }
}
