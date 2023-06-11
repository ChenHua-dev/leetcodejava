package exercise;

import java.util.HashMap;
import java.util.Map;

public class LC904FruitIntoBasket {
    public static int totalFruit(int[] fruits) {
        int k = 2;
        int left = 0, right = 0;
        int maxPick = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        while (right < fruits.length) {
            int currFruit = fruits[right];
//            if (!map.containsKey(currFruit)) {
//                map.put(currFruit, 1);
//            } else {
//                int count = map.get(currFruit);
//                map.put(currFruit, ++count);
//            }
            map.put(currFruit, map.getOrDefault(currFruit, 0) + 1);
            if (map.size() > k) {
                int leftFruit = fruits[left];
                int leftCount = map.get(leftFruit);
                if (leftCount > 1) {
                    map.put(leftFruit, --leftCount);
                } else {
                    map.remove(leftFruit);
                }
                left++;
            }
            maxPick = Math.max(maxPick, right - left + 1);
            right++;
        }
        return maxPick;
    }

    public static void main(String[] args) {
        System.out.println(totalFruit(new int[] {1,2,3,2,2})); // expected 4
        System.out.println(totalFruit(new int[] {1,2,1})); // expected 3
        System.out.println(totalFruit(new int[] {0,1,2,2})); // expected 3
    }
}
