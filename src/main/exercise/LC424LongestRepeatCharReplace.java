package exercise;

import java.util.HashMap;
import java.util.Map;

public class LC424LongestRepeatCharReplace {

    public static int characterReplacement(String s, int k) {
        int longest = Integer.MIN_VALUE;
        int left = 0, right = 0;
        int mostFreq = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (right < s.length()) {
            char currChar = s.charAt(right);
//            if (!map.containsKey(currChar)) {
//                map.put(currChar, 1);
//            } else {
//                int charCount = map.get(currChar);
//                map.put(currChar, ++charCount);
//            }
            map.put(currChar, map.getOrDefault(currChar, 0) + 1);
            mostFreq = Math.max(mostFreq, map.get(currChar));
            int windowLen = right - left + 1;
            if (windowLen - mostFreq > k) {
                char leftChar = s.charAt(left);
                int leftCount = map.get(leftChar);
                map.put(leftChar, --leftCount);
                left++;
            } else {
                longest = Math.max(longest, right - left + 1);
            }
            right++;
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2)); // expected 4
        System.out.println(characterReplacement("AABABBA", 1)); // expected 4
    }
}
