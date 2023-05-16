package exercise;

import java.util.Arrays;

public class LC16ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        int closestToTarget = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sums = nums[i] + nums[left] + nums[right];
                if (target == sums) {
                    return sums;
                } else if (target > sums) {
                    left++;
                    if (closest > Math.abs(sums - target)) {
                        closest = Math.min(closest, Math.abs(sums - target));
                        closestToTarget = sums;
                    }
                } else {
                    right--;
                    if (closest > Math.abs(sums - target)) {
                        closest = Math.min(closest, Math.abs(sums - target));
                        closestToTarget = sums;
                    }
                }
            }
        }
        return closestToTarget;
    }

    public static void main(String[] args) {
        // nums = [-1,2,1,-4], target = 1
        System.out.println(LC16ThreeSumClosest.threeSumClosest(new int[] {-1,2,1,-4}, 1));
        // nums = [0,0,0], target = 1
        System.out.println(LC16ThreeSumClosest.threeSumClosest(new int[] {0,0,0}, 1));
    }
}
