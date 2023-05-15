package exercise;

public class LC977SquareArray {

    public static int[] sortedSquares(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int[] squared = new int[nums.length];
        int i = nums.length - 1;
        while (l <= r) {
            if (nums[l] * nums[l] > nums[r] * nums[r]) {
                squared[i] = nums[l] * nums[l];
                l++;
            } else {
                squared[i] = nums[r] * nums[r];
                r--;
            }
            i--;
        }
        return squared;
    }


    public static void main(String[] args) {
        int[] squared = LC977SquareArray.sortedSquares(new int[] {-7,-3,2,3,11});
        for (int n : squared) System.out.print(n + " ");
    }

}
