package exercise.SlidingWindow;

public class LC53MaxSubarr {
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int right = 0;
        int globalSum = Integer.MIN_VALUE;
        int localSum = 0;
        while (right < n) {
            localSum += nums[right];
            globalSum = Math.max(globalSum, localSum);
            if (localSum < 0) localSum = 0;
            right++;
        }
        return globalSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubArray(new int[] {1}));
        System.out.println(maxSubArray(new int[] {-1}));
        System.out.println(maxSubArray(new int[] {5,4,-1,7,8}));
    }
}
