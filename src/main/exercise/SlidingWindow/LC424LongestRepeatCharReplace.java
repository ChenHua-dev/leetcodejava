package exercise.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LC424LongestRepeatCharReplace {
//    public static int characterReplacement(String s, int k) {
//        int longest = 0, mostFreq = 0, windowLen;
//        int left = 0, right = 0;
//        Map<Character, Integer> map = new HashMap<>();
//
//        while (right < s.length()) {
//            char currChar = s.charAt(right);
//            if (!map.containsKey(currChar)) {
//                map.put(currChar, 1);
//            } else {
//                int charCount = map.get(currChar);
//                map.put(currChar, ++charCount);
//            }
//            // map.put(currChar, map.getOrDefault(currChar, 0) + 1);
//            windowLen = right - left + 1;
//            // most frequent count of a given char within the window
//            int currCount = map.get(currChar);
//            mostFreq = Math.max(mostFreq, currCount);
//            // number of replacement within the window
//            int numReplace = windowLen - mostFreq;
//            if (numReplace > k) {
//                char leftChar = s.charAt(left);
//                int leftCount = map.get(leftChar);
//                map.put(leftChar, --leftCount);
//                left++;
//            }
//            longest = Math.max(longest, right - left + 1);
//            right++;
//        }
//        return longest;
//    }

    public static int characterReplacement(String s, int k) {
        int longest = 0, mostFreq = 0, windowLen;
        int left = 0, right = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (right < s.length()) {
            char currChar = s.charAt(right);
            map.put(currChar, map.getOrDefault(currChar, 0) + 1);
            // most frequent count of a given char within the window
            mostFreq = Math.max(mostFreq, map.get(currChar));
            // number of replacement within the window
            windowLen = right - left + 1;
            int numReplace = windowLen - mostFreq;
            while (numReplace > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                // decrementing left pointer, then update window size
                left++;
                windowLen = right - left + 1;
                numReplace = windowLen - mostFreq;
            }
            longest = Math.max(longest, right - left + 1);
            right++;
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2)); // expected 4
        System.out.println(characterReplacement("AABABBA", 1)); // expected 4
        System.out.println(characterReplacement("AABACBABB", 2)); // expected 5
        System.out.println(characterReplacement("ABABAABA", 2)); // expected 6
    }
}
