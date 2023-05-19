package exercise;

public class LC3LongestSubstr {

    public static void printAllSubstr(String s) {

        System.out.println("print all substrings a given string <" + s + ">");
        for (int i = 0; i < s.length(); i++) {
            // given <currChar> find all its combinations
            char curr = s.charAt(i);
            System.out.print(curr + ": ");
            String combo = "";
            for (int j = i; j < s.length(); j++) {
                char temp = s.charAt(j);
                combo += temp;
                System.out.print(combo + " ");
            }
            System.out.println();
        }
    }

//    public static void printSubstrNoRepeat(String s) {
//        System.out.println("find substrings of " + s + " that does not have repeated char: ");
//        int n = s.length();
//        for (int i = 0; i < n; i++) {
//            char currChar = s.charAt(i);
//            System.out.print(currChar + ": ");
//            String combo = "";
//            for (int j = i; j < n; j++) {
//                char nextChar = s.charAt(j);
//                boolean repeatedChar = combo.contains("" + nextChar);
//                if (!repeatedChar) {
//                    combo += Character.toString(nextChar);
//                    System.out.print(combo + " ");
//                } else
//                    break;
//            }
//            System.out.println();
//        }
//    }

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

    public static void printSubstrNoRepeat (String s) {

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            System.out.print(curr + ": ");
            String combo = "";
            for (int j = i; j < s.length(); j++) {
                char temp = s.charAt(j);
                if (combo.contains(Character.toString(temp))) {
                    break;
                } else {
                    combo += temp;
                    System.out.print(combo + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        LC3LongestSubstr.printAllSubstr(s);
        System.out.println();
        LC3LongestSubstr.printSubstrNoRepeat(s);
//        int maxLen = LC3LongestSubstr.myVerlengthOfLongestSubstring(s);
//        System.out.println(maxLen);
//        LC3LongestSubstr answer = new LC3LongestSubstr();
//        answer.lengthOfLongestSubstring(s);
    }
}
