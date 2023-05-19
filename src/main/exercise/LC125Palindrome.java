package exercise;

public class LC125Palindrome {

    public static boolean isPalindrome(String s) {
        if (s.length() < 2) return true;
        int n = s.length();
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            char cL = Character.toLowerCase(s.charAt(left));
            char rL = Character.toLowerCase(s.charAt(right));

            while (left < n - 1 && !Character.isLetterOrDigit(cL)) {
                left++;
                cL = Character.toLowerCase(s.charAt(left));
            }
            while (right > 0 && !Character.isLetterOrDigit(rL)) {
                right--;
                rL = Character.toLowerCase(s.charAt(right));
            }

            if (Character.isLetterOrDigit(cL) && Character.isLetterOrDigit(rL) && cL != rL) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(Character.isLetterOrDigit(' '));
        System.out.println(LC125Palindrome.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(LC125Palindrome.isPalindrome("race a car"));
        System.out.println(LC125Palindrome.isPalindrome(" "));
        System.out.println(LC125Palindrome.isPalindrome("a."));
        System.out.println(LC125Palindrome.isPalindrome(".,"));
        System.out.println(LC125Palindrome.isPalindrome("0P"));
        System.out.println(LC125Palindrome.isPalindrome("a.b,.")); // expect false
    }

}
