package exercise;

public class LC75SortColor {

    public static void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        // index <i> for scanning through each element
        int i = 0;

        while (i <= right && left < right) {
            if (nums[i] == 0) {
                swap(nums, i, left);
                i++;
                left++;
            } else if (nums[i] == 2) {
                swap(nums, i, right);
                right--;
                // no i++: b/c the newly swapped value from the end has not been seen yet, i.e. by accessed by nums[i]. If i++, you will never be able to access this value at nums[i]
                // contrary, when nums[i] == 0, i++ b/c you throw value to the back, and is guaranteed to be seen later because sooner or later index <i> will traverse there
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,0,2,1,1,0};
        sortColors(nums);
        for (int num : nums) System.out.print(num + " ");
    }

}
