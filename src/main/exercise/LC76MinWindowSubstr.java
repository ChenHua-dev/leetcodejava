package exercise;

public class LC76MinWindowSubstr {
    public static String minWindow(String s, String t) {
        String minLenStr = "";
        int minLen = Integer.MAX_VALUE, left = 0, right = 0;
        int countAllCharInStrT = 0;
        int[] mapStrT = new int[128];
        //Set up the table for string <t>
        char[] tArray = t.toCharArray();
        for (char c : tArray) {
            mapStrT[c]++;
        }

        while (right < s.length()) {
            //Expand the window
            char charRight = s.charAt(right);
            mapStrT[charRight]--;
            if(mapStrT[charRight] >= 0) countAllCharInStrT++;
            //Shrink the window if current window contains all the char in t
            while(countAllCharInStrT == t.length()){
                //Update the minLen
                if(minLen > right - left + 1) {
                    minLen = right - left + 1;
                    minLenStr = s.substring(left, right + 1);
                }
                //Shrink the window
                char charLeft = s.charAt(left);
                mapStrT[charLeft]++;
                if(mapStrT[charLeft] > 0) countAllCharInStrT--;
                left++;
            }
            right++;
        }
        return minLenStr;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC")); // expect "BANC"
        System.out.println(minWindow("a", "a")); // expect "a"
        System.out.println(minWindow("a", "aa")); // expect ""
    }
}
