package exercise.FastSlowPointer;

public class LC287FindDuplicateNum {

    public static int findDuplicate(int[] nums) {
        int dup = -1;
        for (int i = 0; i < nums.length; i++) {
            int curr = Math.abs(nums[i]);
            if (nums[curr] < 0) {
                dup = curr;
                break;
            } else {
                nums[curr] = -1 * nums[curr];
            }
        }
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }
        return dup;
    }

    public static void main(String[] args) {

    }
}
