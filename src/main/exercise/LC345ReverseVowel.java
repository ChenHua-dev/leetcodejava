package exercise;

public class LC345ReverseVowel {

    public static String reverseVowels(String s) {
        if (s.length() < 2) return s;
        String[] res = new String[s.length()];
        String vowels = "aeiouAEIOU";
        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            String cLeft = "" + s.charAt(left);
            String cRight = "" + s.charAt(right);
            if (!vowels.contains(cLeft) && !vowels.contains(cRight)) {
                res[left] = cLeft;
                res[right] = cRight;
                left++;
                right--;
            } else if (vowels.contains(cLeft) && !vowels.contains(cRight)) {
                res[right] = cRight;
                right--;
            } else if (!vowels.contains(cLeft) && vowels.contains(cRight)) {
                res[left] = cLeft;
                left++;
            } else if (vowels.contains(cLeft) && vowels.contains(cRight)) {
                res[left] = cRight;
                res[right] = cLeft;
                left++;
                right--;
            }
        }
        return String.join("", res);
    }

    public static void main(String[] args) {
        String s = "hello";
//        char[] temp = new char[s.length()];
//        System.out.println(temp.length);
        System.out.println(LC345ReverseVowel.reverseVowels(",."));
        System.out.println(LC345ReverseVowel.reverseVowels("a."));
        System.out.println(LC345ReverseVowel.reverseVowels("hello"));
        System.out.println(LC345ReverseVowel.reverseVowels("leetcode"));
    }

}
