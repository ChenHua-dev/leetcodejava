package exercise;

public class LC581ShortestUnsorted {
    public static int findUnsortedSubarray(int[] nums) {
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        boolean unsortedFlag = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i])
                unsortedFlag = true;
            if (unsortedFlag)
                minVal = Math.min(minVal, nums[i]); // find the minimum value that was out-of-order for the 1st time
        }
        unsortedFlag = false;
        for (int j = nums.length - 2; j >= 0; j--) {
            if (nums[j] > nums[j + 1])
                unsortedFlag = true;
            if (unsortedFlag)
                maxVal = Math.max(maxVal, nums[j]); // find the maximum value that was out-of-order for the 1st time
        }
        int left, right;
        for (left = 0; left < nums.length; left++) {
            if (minVal < nums[left])
                break;
        }
        for (right = nums.length - 1; right >= 0; right--) {
            if (nums[right] < maxVal)
                break;
        }
        int res;
        if (right < left) res = 0;
        else res = right - left + 1;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[] {1, 3, 2, 0, -1, 7, 10})); // expect 5, [1, 3, 2, 0, -1]
        System.out.println(findUnsortedSubarray(new int[] {2, 6, 4, 8, 10, 9, 15})); // expect 5, [6, 4, 8, 10, 9]
        System.out.println(findUnsortedSubarray(new int[] {2, 6, 4, 8, 15, 10, 9})); // expect 6, [6, 4, 8, 15, 10, 9]
        System.out.println(findUnsortedSubarray(new int[] {1, 2, 3, 4})); // expect 0
        System.out.println(findUnsortedSubarray(new int[] {1, 2, 3})); // expect 0
        System.out.println(findUnsortedSubarray(new int[] {3, 2, 1})); // expect 3
        System.out.println(findUnsortedSubarray(new int[] {1, 2, 2, 1, 8, 6, 9}));
        System.out.println(findUnsortedSubarray(new int[] {1})); // expect 0

    }
}
