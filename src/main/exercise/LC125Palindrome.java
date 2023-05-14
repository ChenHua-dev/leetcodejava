package exercise;

public class LC125Palindrome {

    public static boolean isPalindrome(String s) {
        if (s.length() < 2) return true;
        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            char charL = s.charAt(left);
            char charR = s.charAt(right);

            while (left < s.length() - 1 && !Character.isLetterOrDigit(charL)) {
                left++;
                charL = s.charAt(left);
            }
            while (right > 0 && !Character.isLetterOrDigit(charR)) {
                right--;
                charR = s.charAt(right);
            }

            if (Character.isLetterOrDigit(charL) && Character.isLetterOrDigit(charR) &&
                    Character.toLowerCase(charL) != Character.toLowerCase(charR)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        char c1 = ':';
//        char c2 = ' ';
//        System.out.println(Character.isAlphabetic(c1));
//        System.out.println(Character.isAlphabetic(c2));
//        String s = "A man, a plan, a canal: Panama";
//        String s = "race a car";
        String s = ".,";
        System.out.println(LC125Palindrome.isPalindrome(s));
    }

}
