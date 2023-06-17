package exercise.SlidingWindow;

/**
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 */

public class LC485MaxConsecOne1 {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxNum = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            int curr = nums[right];
            if (curr != 1) {
                right++;
                left = right;
            } else {
                maxNum = Math.max(maxNum, right - left + 1);
                right++;
            }
        }
        return maxNum;
    }

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[] {1,1,0,1,1,1})); // expect 3
        System.out.println(findMaxConsecutiveOnes(new int[] {1,0,1,1,0,1})); // expect 2
    }
}
