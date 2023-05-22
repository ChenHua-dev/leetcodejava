package exercise;

import java.util.*;

public class LC18FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> s = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sums = (long) nums[i] + (long) nums[j] + (long) nums[left] + (long) nums[right];
                    if (target > sums) left++;
                    else if (target < sums) right--;
                    else {
                        List<Integer> quad = Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
                        s.add(quad);
                        while (left < right && nums[left] == quad.get(2)) left++;
                        while (left < right && nums[right] == quad.get(3)) right--;
                    }
                }
                while (j < n - 1 && nums[j] == nums[j + 1]) j++; //
            }
            while (i < n - 1 && nums[i] == nums[i + 1]) i++; //
        }
        return new ArrayList<>(s);
    }

    public static void main(String[] args) {
        LC18FourSum.fourSum(new int[] {4, 1, 2, -1, 1, -3}, 1);
        LC18FourSum.fourSum(new int[] {2, 0, -1, 1, -2, 2}, 2);
        LC18FourSum.fourSum(new int[] {1, 0, -1, 0, -2, 2}, 0);
        LC18FourSum.fourSum(new int[] {2, 2, 2, 2, 2}, 8);
    }

}
