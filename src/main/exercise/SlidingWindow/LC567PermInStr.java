package exercise.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LC567PermInStr {
    public static boolean checkInclusion (String s1, String s2) {
        int left = 0, right = 0, countCharNeededInS2 = 0;
        Map<Character, Integer> mapS1 = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : s1.toCharArray()) mapS1.put(c, mapS1.getOrDefault(c, 0) + 1);
        for (char c : s1.toCharArray()) window.put(c, window.getOrDefault(c, 0));

        while (right < s2.length()) {
            char charRight = s2.charAt(right);
            if (mapS1.containsKey(charRight)) {
                if (window.get(charRight) < mapS1.get(charRight)) countCharNeededInS2++;
                int countRight = window.get(charRight);
                window.put(charRight, ++countRight);
            }

            while (countCharNeededInS2 == s1.length()) {
                int windowSize = right - left + 1;
                if (windowSize == s1.length()) {
                    return true;
                } else {
                    // update window size by decrementing left pointer
                    char charLeft = s2.charAt(left);
                    if (mapS1.containsKey(charLeft)) {
                        if (window.get(charLeft) <= mapS1.get(charLeft)) countCharNeededInS2--;
                        int countLeft = window.get(charLeft);
                        window.put(charLeft, --countLeft);
                    }
                    left++;
                }
            }
            right++;
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(checkInclusion("abc","baxyzabc")); // true
        System.out.println(checkInclusion("ab","eidbaooo")); // true
        System.out.println(checkInclusion("ab","eidboaoo")); // false
    }
}
