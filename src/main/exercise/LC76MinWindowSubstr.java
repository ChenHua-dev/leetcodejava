package exercise;

import java.util.HashMap;
import java.util.Map;

public class LC76MinWindowSubstr {
//    public String minWindow(String s, String t) {
//        String minLenStr = "";
//        int minLen = Integer.MAX_VALUE, left = 0, right = 0;
//        int countAllCharInStrT = 0;
//        int[] mapStrT = new int[128];
//        //Set up the table for string <t>
//        char[] tArray = t.toCharArray();
//        for (char c : tArray) mapStrT[c]++;
//
//        while (right < s.length()) {
//            //Expand the window
//            char charRight = s.charAt(right);
//            mapStrT[charRight]--;
//            if(mapStrT[charRight] >= 0) countAllCharInStrT++;
//            //Shrink the window if current window contains all the char in t
//            while(countAllCharInStrT == t.length()){
//                //Update the minLen
//                if(minLen > right - left + 1){
//                    minLen = right - left + 1;
//                    minLenStr = s.substring(left, right + 1);
//                }
//                //Shrink the window
//                char charLeft = s.charAt(left);
//                mapStrT[charLeft]++;
//                if(mapStrT[charLeft] > 0) countAllCharInStrT--;
//                left++;
//            }
//            right++;
//        }
//        return minLenStr;
//    }

    public static String minWindow(String s, String t) {
        String minLenStr = "";
        int minLen = Integer.MAX_VALUE, left = 0, right = 0, countAllCharInStrT = 0;
        Map<Character, Integer> window = new HashMap<>(), mapT = new HashMap<>();
        //Set up the table for string <t>
        for (char c : t.toCharArray()) mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        for (char c : t.toCharArray()) window.put(c, window.getOrDefault(c, 0));
        while (right < s.length()) {
            //Expand the window
            char charRight = s.charAt(right);
            if (mapT.containsKey(charRight)) {
                if(window.get(charRight) < mapT.get(charRight)) countAllCharInStrT++;
                int countRight = window.get(charRight);
                window.put(charRight, ++countRight);
            }
            //Shrink the window if current window contains all the char in t
            while (countAllCharInStrT == t.length()) {
                //Update the minLen
                if(minLen > right - left + 1) {
                    minLen = right - left + 1;
                    minLenStr = s.substring(left, right + 1);
                }
                //Shrink the window
                char charLeft = s.charAt(left);
                if (mapT.containsKey(charLeft)) {
                    if(window.get(charLeft) <= mapT.get(charLeft)) countAllCharInStrT--;
                    int countLeft = window.get(charLeft);
                    window.put(charLeft, --countLeft);
                }
                left++;
            }
            right++;
        }
        return minLenStr;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("bbaa", "aba")); // expect "baa"
        System.out.println(minWindow("aa", "aa")); // expect "aa"
        System.out.println(minWindow("ADOBECODEBANC", "ABC")); // expect "BANC"
        System.out.println(minWindow("bba", "ab")); // expect "ba"
        System.out.println(minWindow("a", "a")); // expect "a"
        System.out.println(minWindow("a", "aa")); // expect ""
    }
}
