package exercise;

import java.util.*;

public class LC15ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int target = 0;
        Set<List<Integer>> s = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sums = nums[i] + nums[left] + nums[right];
                if (sums == target) {
                    s.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (target > sums) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return new ArrayList<>(s);
    }

    public static void main(String[] args) {
        List<List<Integer>> res = LC15ThreeSum.threeSum(new int[] {-1,0,1,2,-1,-4});
    }

}
