package exercise;

public class LC14LongestCommPref {
    public String longestCommonPrefix(String[] strs) {
        // assume the element from index 0 is the prefix
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            // keep looping until prefix is contained in strs[i]
            // and first occurrence is from index 0
            while (strs[i].indexOf(prefix) != 0) {
                int trimIndex = prefix.length() - 1;
                prefix = prefix.substring(0, trimIndex);
            }
            if (prefix.equals("")) {
                return "";
            }
        }
        return prefix;
    }

    public static String longestCommonPrefix2(String[] strs) {
        String prefix = strs[0];
        for (String str : strs) {
            // min length between current string and assumed prefix
            int minLen = Math.min(str.length(), prefix.length());
            // update prefix
            prefix = prefix.substring(0, minLen);
            // traverse min length, compare between assumed prefix and current string at each char
            for (int i = 0; i < minLen; i++) {
                if (prefix.charAt(i) != str.charAt(i)) {
                    // if compared chars are not the same, then update the prefix at current index
                    prefix = prefix.substring(0, i);
                    break;
                }
            }
        }
        return prefix;
    }

    public static String longestCommonPrefixReview(String[] strs) {
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            int minLen = Math.min(prefix.length(), strs[i].length());
            prefix = prefix.substring(0, minLen);

            for (int j = 0; j < prefix.length(); j++) {
                if (prefix.charAt(j) != strs[i].charAt(j)) {
                    prefix = prefix.substring(0, j);
                    break;
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String prefix = "flower";
        String str1 = "flow";
        // prefix is a substring of str1 starting from index XXX
        //
//        int startPos = str1.indexOf(prefix);
//        boolean startPos = str1.contains(prefix);
//        System.out.println(prefix.contains(str1));
        System.out.println(LC14LongestCommPref.longestCommonPrefixReview(new String[] {"flower", "flow", "flight"}));
//        System.out.println("flowerfl".indexOf("fl"));
//        System.out.println("flowerfl".lastIndexOf("fl"));
//        System.out.println(prefix.substring(0, prefix.length()-1));
    }

}
