package exercise;

import java.util.HashMap;

public class LC340LenLongestSubstrKDistinct {

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int longest = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            char currChar = s.charAt(right);
            if (!map.containsKey(currChar)) {
                map.put(currChar, 1);
            } else {
                int count = map.get(currChar);
                map.put(currChar, ++count);
            }
            if (map.size() > k) {
                int currCount = map.get(s.charAt(left));
                if (currCount > 1) {
                    currCount--;
                    map.put(s.charAt(left), currCount);
                } else {
                    map.remove(s.charAt(left));
                }
                left++;
            }
            longest = Math.max(longest, right - left + 1);
            right++;
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2)); // expected 3
        System.out.println(lengthOfLongestSubstringKDistinct("aa", 1)); // expected 2
        System.out.println(lengthOfLongestSubstringKDistinct("abaccc", 2)); // expected 4
    }

}
