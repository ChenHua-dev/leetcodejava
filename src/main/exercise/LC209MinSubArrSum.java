package exercise;

public class LC209MinSubArrSum {
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
         int minLength = Integer.MAX_VALUE;
        int sum = 0;
        while (right < n) {
            sum += nums[right];
            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[] {2,3,1,2,4,3})); // expected 2
        System.out.println(minSubArrayLen(4, new int[] {4,3})); // expected 1
        System.out.println(minSubArrayLen(4, new int[] {1,4,4})); // expected 1
        System.out.println(minSubArrayLen(11, new int[] {1,1,1,1,1,1,1,1})); // expected 0
    }
}
