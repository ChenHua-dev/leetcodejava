package exercise;

import java.util.Arrays;

public class LC259ThreeSumSmaller {

    public static int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sums = nums[i] + nums[left] + nums[right];
                if (target > sums) {
                    counter += right - left;
                    left++;
                } else {
                    right--;
                }

            }
        }
        return counter;
    }

    public static void main(String[] args) {
//        int res = LC259ThreeSumSmaller.threeSumSmaller(new int[] {-2,0,1,3}, 2);
        int res = LC259ThreeSumSmaller.threeSumSmaller(new int[] {-1, 4, 2, 1, 3}, 5);
//        int res = LC259ThreeSumSmaller.threeSumSmaller(new int[] {30, 30, 30, 30, 30, 30, 30, 30, 30}, 1);
        System.out.println(res);
    }


}
