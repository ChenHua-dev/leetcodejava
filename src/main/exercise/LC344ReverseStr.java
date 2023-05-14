package exercise;

public class LC344ReverseStr {

    public static void reverseString(char[] s) {
        // 2-pointer
        int left = 0;
        int right = s.length - 1;

        // loop condition: left <= right
        while (left <= right) {
            // swap
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
//        char[] s = new char[] {'h','e','l','l','o'};
        char[] s = new char[] {'H','a','n','n','a','h'};
        LC344ReverseStr.reverseString(s);
        System.out.println(s);
    }

}
