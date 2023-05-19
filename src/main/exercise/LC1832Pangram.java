package exercise;

import java.util.HashSet;

public class LC1832Pangram {

    // this is faster
    public static boolean checkIfPangram(String s) {
        // traverse 26 alphabets
        for (int i = 0; i < 26; i++) {
            char curr = (char) ('a' + i);
            if (!s.contains(Character.toString(curr)) && !s.contains(Character.toString(Character.toUpperCase(curr)))) {
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
//        String sentence = "thequickbrownfoxjumpsoverthelazydog";
        String sentence = "TheQuickBrownFoxJumpsOverTheLazyDog";
        boolean pangram = LC1832Pangram.checkIfPangram(sentence);
        if (!pangram) {
            System.out.println("false");
        } else {
            System.out.println("true");
        }

    }
}
