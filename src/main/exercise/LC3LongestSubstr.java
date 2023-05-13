package exercise;

import java.util.HashSet;
import java.util.Set;

public class LC3LongestSubstr {

//    public int lengthOfLongestSubstring(String s) {
//        return 0;
//    }

    public static void printAllSubstr(String s) {
        System.out.println("find all substrings of " + s + ": ");
        int n = s.length();
        for (int i = 0; i < n; i++) {
            // given <currChar> find all its combinations
            char currChar = s.charAt(i);
            System.out.print(currChar + ": ");
            String combo = "";
            for (int j = i; j < n; j++) {
                char nextChar = s.charAt(j);
                combo = combo + Character.toString(nextChar);
                System.out.print(combo + " ");
            }
            System.out.println();
        }
    }

    public static void printSubstrNoRepeat(String s) {
        System.out.println("find substrings of " + s + " that does not have repeated char: ");
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char currChar = s.charAt(i);
            System.out.print(currChar + ": ");
            String combo = "";
            for (int j = i; j < n; j++) {
                char nextChar = s.charAt(j);
                boolean repeatedChar = combo.contains("" + nextChar);
                if (!repeatedChar) {
                    combo += Character.toString(nextChar);
                    System.out.print(combo + " ");
                } else
                    break;
            }
            System.out.println();
        }
    }

    public static int myVerlengthOfLongestSubstring(String s) {
        System.out.println("find max length of non-repeated substring of " + s + ": ");
        int maxLen = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char currChar = s.charAt(i);
            System.out.print(currChar + ": ");
            String combo = "";
            for (int j = i; j < n; j++) {
                char nextChar = s.charAt(j);
                boolean repeatedChar = combo.contains("" + nextChar);
                if (!repeatedChar) {
                    combo += Character.toString(nextChar);
                    System.out.print(combo + " ");
                    maxLen = Math.max(maxLen, combo.length());
                } else
                    break;
            }
            System.out.println();
        }
        return maxLen;
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int lenLongestSubstr = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (checkRepetition(s, i, j)) {
                    int currLenViewed = j - i + 1;
                    // update length of longest substring
                    lenLongestSubstr = Math.max(lenLongestSubstr, currLenViewed);
                }
            }
        }
        return lenLongestSubstr;
    }

    private boolean checkRepetition(String s, int start, int end) {
        Set<Character> chars = new HashSet<>();
        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            // if there is repetition, break the loop and return false immediately
            if(chars.contains(c))
                return false;
            else
                chars.add(c);
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "";
//        LC3LongestSubstr.printAllSubstr(s);
//        System.out.println();
//        LC3LongestSubstr.printSubstrNoRepeat(s);
        int maxLen = LC3LongestSubstr.myVerlengthOfLongestSubstring(s);
        System.out.println(maxLen);
        LC3LongestSubstr answer = new LC3LongestSubstr();
        answer.lengthOfLongestSubstring(s);
    }
}
