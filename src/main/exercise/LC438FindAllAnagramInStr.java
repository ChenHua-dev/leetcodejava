package exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC438FindAllAnagramInStr {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int left = 0, right = 0, countCharNeededInS = 0;
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> mapP = new HashMap<>();
        for (char c : p.toCharArray()) mapP.put(c, mapP.getOrDefault(c, 0) + 1);
        for (char c : p.toCharArray()) window.put(c, window.getOrDefault(c, 0));

        while (right < s.length()) {
            char charRight = s.charAt(right);
            if (mapP.containsKey(charRight)) {
                if (window.get(charRight) < mapP.get(charRight)) countCharNeededInS++;
                window.put(charRight, window.get(charRight) + 1);
            }
            while (countCharNeededInS == p.length()) {
                int windowSize = right - left + 1;
                if (windowSize == p.length()) res.add(left);
                char charLeft = s.charAt(left);
                if(mapP.containsKey(charLeft)){
                    if(window.get(charLeft) <= mapP.get(charLeft)) countCharNeededInS--;
                    window.put(charLeft, window.get(charLeft) - 1);
                }
                left++;
            }
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> res;
        res = findAnagrams("cbaebabacd", "abc");
        for (int i : res) System.out.print(Integer.toString(i) + ' ');
        System.out.println();
        res = findAnagrams("abab", "ab");
        for (int i : res) System.out.print(Integer.toString(i) + ' ');
    }
}
