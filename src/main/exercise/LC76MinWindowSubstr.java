package exercise;

public class LC76MinWindowSubstr {

    public static String minWindow(String s, String t) {
        String minLenStr = "";
        int minLen = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int countAllCharInT = 0;
        int[] map = new int[128];
        //Set up the table
        for(char c : t.toCharArray()){
            map[c]++;
        }

        char[] arr = s.toCharArray();
        while(right < s.length()){
            //Expand the window
            map[arr[right]]--;
            if(0 <= map[arr[right]]){
                countAllCharInT++;
            }
            //Shrink the window if current window contains all the char in t
            while(countAllCharInT == t.length()){
                //Update the minLen
                if(minLen > right - left + 1){
                    minLen = right - left + 1;
                    minLenStr = s.substring(left, right + 1);
                }
                //Shrink the window
                map[arr[left]]++;
                if(0 < map[arr[left]]){
                    countAllCharInT--;
                }
                left++;
            }
            right++;
        }
        return minLenStr;
    }

    public static void main(String[] args) {

    }
}
