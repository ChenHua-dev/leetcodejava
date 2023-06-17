package exercise.SlidingWindow;

/**
 * Given a binary array nums,
 * return the maximum number of consecutive 1's in the array if you can flip at most one 0
 */

public class LC487MaxConsecOne2 {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int k = 1;
        int maxNum = 0;
        int left = 0, right = 0;
        int zerosCount = 0;
        while (right < nums.length) {
            int curr = nums[right];
            if (curr == 0) {
                zerosCount++;
            }
            while (zerosCount > k) {
//                zerosCount--;
//                left += 2;
                if (nums[left] == 1) {
                    left++;
                } else {
                    zerosCount--;
                    left++;
                }
            }
            maxNum = Math.max(maxNum, right - left + 1);
            right++;
        }
        return maxNum;
    }

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[] {1,0,1,1,0})); // expect 4
        System.out.println(findMaxConsecutiveOnes(new int[] {1,0,1,1,0,1})); // expect 4
        System.out.println(findMaxConsecutiveOnes(new int[] {1,1,1,0,1,1,1,0,1,1,1,1})); // expect 8
    }
}
