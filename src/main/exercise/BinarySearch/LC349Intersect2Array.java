package exercise.BinarySearch;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC349Intersect2Array {
    public static int search (int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int[] intersection (int[] nums1, int[] nums2) {
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<>();
        for (int n : nums1) {
            int currIdx = search(nums2, n);
            if (currIdx != -1 && !res.contains(nums2[currIdx])) { // means found
                res.add(nums2[currIdx]);
            }
        }
        return res.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        int[] res1 = intersection(new int[] {1,2,2,1}, new int[] {2,2}); // expect [2]
        int[] res2 = intersection(new int[] {4,9,5}, new int[] {9,4,9,8,4});
        for (int r : res1) System.out.print(Integer.toString(r) + ' ');
        System.out.println();
        for (int r : res2) System.out.print(Integer.toString(r) + ' ');
    }


}
