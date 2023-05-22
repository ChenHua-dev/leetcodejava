package exercise;

public class LC844BackspaceCompare {

    public static boolean backspaceCompare(String s, String t) {
        String str1 = helper(s);
        String str2 = helper(t);
        return str1.equals(str2);
    }

    private static String helper(String s) {
        String trimmed = "";
        int index = s.length() - 1;
        int skipper = 0;

        while (index >= 0) {
            while (index >= 0 && s.charAt(index) == '#') {
                index--;
                skipper++;
            }

            if (index >= 0 && s.charAt(index) != '#') {
                if (skipper > 0) skipper--;
                else trimmed += s.charAt(index);
                index--;
            }
        }
        return trimmed;
    }

    public static void main(String[] args) {
        System.out.println(LC844BackspaceCompare.backspaceCompare("ab#c", "ad#c")); // expect: true
        System.out.println(LC844BackspaceCompare.backspaceCompare("ab##", "c#d#")); // expect: true
        System.out.println(LC844BackspaceCompare.backspaceCompare("a#c", "b")); // expect: false
        System.out.println(LC844BackspaceCompare.backspaceCompare("xy#z", "xzz#")); // expect: true
        System.out.println(LC844BackspaceCompare.backspaceCompare("xy#z", "xyz#")); // expect: false
        System.out.println(LC844BackspaceCompare.backspaceCompare("xp#", "xyz##")); // expect: true
        System.out.println(LC844BackspaceCompare.backspaceCompare("a##c", "#a#c")); // expect: true
        System.out.println(LC844BackspaceCompare.backspaceCompare("bxj##tw", "bxo#j##tw")); // expect: true
    }

}
