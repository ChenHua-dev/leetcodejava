package exercise;

public class LC345ReverseVowel {

    public static String reverseVowels(String s) {
        if (s.length() < 2) return s;
        char[] chars = new char[s.length()];
        String vowels = "aeiouAEIOU";
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            char charL = s.charAt(l);
            char charR = s.charAt(r);
            if (!vowels.contains(""+charL) && !vowels.contains(""+charR)) {
                chars[l] = charL;
                chars[r] = charR;
                l++;
                r--;
            } else if (vowels.contains(""+charL) && !vowels.contains(""+charR)) {
                chars[r] = charR;
                r--;
            } else if (!vowels.contains(""+charL) && vowels.contains(""+charR)) {
                chars[l] = charL;
                l++;
            } else {
                chars[r] = charL;
                chars[l] = charR;
                l++;
                r--;
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        String s = "hello";
//        char[] temp = new char[s.length()];
//        System.out.println(temp.length);
        System.out.println(LC345ReverseVowel.reverseVowels("a."));

    }

}
