package exercise;

public class LC26RemoveDup {

    public static int removeDuplicates(int[] nums) {

        int reader = 1; // reader index traverse the whole int[] array
        int writer = 1;
        int n = nums.length;

        while (reader < n) { // reader traverse from 0 to n - 1 (last index in the array)
            if (nums[reader - 1] == nums[reader]) {
                reader++;
            } else {
                nums[writer] = nums[reader];
                reader++;
                writer++;
            }
        }
        return writer;
    }


    public static void main(String[] args) {
        int[] nums = new int[] {1,1,2,3,3};
        System.out.println(LC26RemoveDup.removeDuplicates(nums));
        for (int n : nums) System.out.print(n);
    }

}
