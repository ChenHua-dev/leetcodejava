package exercise;

import java.util.HashMap;

public class LC1512GoodPair {

    public static int numIdenticalPairs(int[] nums) {
        int counter = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int curr : nums) {
            if (!map.containsKey(curr)) {
                map.put(curr, 1);
            } else {
                int rep = map.get(curr);
                counter += rep;
                map.put(curr, ++rep);
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(LC1512GoodPair.numIdenticalPairs(new int[] {1,2,3,1,1,3}));
        System.out.println(LC1512GoodPair.numIdenticalPairs(new int[] {1,1,1,1}));
        System.out.println(LC1512GoodPair.numIdenticalPairs(new int[] {1,2,3}));
    }
}
