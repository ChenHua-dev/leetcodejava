package exercise;

public class LC1512GoodPair {

    public static int numIdenticalPairs(int[] nums) {
        int n = nums.length;
        int counter = 0;
        for (int i = 0; i < n - 1; i++) {
            int currInt = nums[i];
            for (int j = i + 1; j < n; j++) {
                if (currInt == nums[j]) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
//        System.out.println(LC1512GoodPair.numIdenticalPairs(new int[] {1,2,3,1,1,3}));
//        System.out.println(LC1512GoodPair.numIdenticalPairs(new int[] {1,1,1,1}));
        System.out.println(LC1512GoodPair.numIdenticalPairs(new int[] {1,2,3}));
    }
}
