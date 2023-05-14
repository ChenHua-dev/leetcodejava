package exercise;

import java.util.HashMap;
import java.util.Set;

public class LC242Anagram {

    public static boolean isAnagram(String s, String t) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (!map.containsKey(currChar)) {
                map.put(currChar, 1);
            } else {
                int count = map.get(currChar);
                count++;
                map.put(currChar, count);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char newChar = t.charAt(i);
            if(map.containsKey(newChar)) {
                int count2 = map.get(newChar);
                count2--;
                map.put(newChar, count2);
            } else {
                return false;
            }
        }

        Set<Character> set = map.keySet();
        for (char c : set) {
            if (map.get(c) != 0) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(LC242Anagram.isAnagram("a", "ab"));
    }

}
