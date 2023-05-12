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

    public static void main(String[] args) {
        String prefix = "flower";
        String str1 = "flow";

        // prefix is a substring of str1 starting from index XXX
        //
//        int startPos = str1.indexOf(prefix);
//        boolean startPos = str1.contains(prefix);
//        System.out.println(prefix.contains(str1));
        System.out.println("flowerfl".indexOf("fl"));
        System.out.println("flowerfl".lastIndexOf("fl"));
        System.out.println(prefix.substring(0, prefix.length()-1));
    }

}
