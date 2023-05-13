package exercise;

import java.util.HashSet;

public class LC1832Pangram {

    // this is faster
    public static boolean checkIfPangram(String sentence) {
        int alphabet = 26;
        for (int i = 0; i < alphabet; i++) {
            char currChar = (char) ('a' + i);
            if (!sentence.contains("" + currChar)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkIfPangramHashSet(String sentence) {
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < sentence.length(); i++) {
            set.add(sentence.charAt(i));
        }

        return set.size() == 26;
    }

    public static void main(String[] args) {
        String sentence = "thequickbrownfoxjumpsoverthelazydog";
        boolean pangram = LC1832Pangram.checkIfPangramHashSet(sentence);
        if (!pangram) {
            System.out.println("false");
        } else {
            System.out.println("true");
        }

    }
}
