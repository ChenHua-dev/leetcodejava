package exercise;

import java.util.HashMap;
import java.util.Set;

public class LC242Anagram {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            String curr = Character.toString(t.charAt(i));
            if (!map.containsKey(curr)) {
                map.put(curr, 1);
            } else {
                int count = map.get(curr);
                map.put(curr, ++count);
            }
        }

        for (int j = 0; j < s.length(); j++) {
            String next = Character.toString(s.charAt(j));
            if (map.containsKey(next)) {
                int count2 = map.get(next);
                map.put(next, --count2);
            }
        }

        Set<String> set = map.keySet();
        for (String str : set) {
            if (map.get(str) != 0) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(LC242Anagram.isAnagram("anagram", "nagaram"));
        System.out.println(LC242Anagram.isAnagram("a", "ab"));
    }

}
