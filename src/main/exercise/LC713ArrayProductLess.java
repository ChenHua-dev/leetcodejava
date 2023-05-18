package exercise;

public class LC713ArrayProductLess {

    public static int numSubarrayProductLessThanK (int[] nums, int k) {
        int n = nums.length;
        int counter = 0;
        int L = 0, R = 0;
        int prod = 1;

        while (R < n) {
            prod = prod * nums[R];
            while (L <= R && prod >= k) {
                prod = prod / nums[L];
                L++;
            }
            counter += (R - L + 1); // 1 | 2 | ... | n
            R++;
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(LC713ArrayProductLess.numSubarrayProductLessThanK(new int[] {10,5,2,6}, 100)); // expect 8
        System.out.println(LC713ArrayProductLess.numSubarrayProductLessThanK(new int[] {1,2,3}, 0)); // expect 0
        System.out.println(LC713ArrayProductLess.numSubarrayProductLessThanK(new int[] {2, 5, 3, 10}, 30)); // expect 6
        System.out.println(LC713ArrayProductLess.numSubarrayProductLessThanK(new int[] {8, 2, 6, 5}, 50)); // expect 7
        System.out.println(LC713ArrayProductLess.numSubarrayProductLessThanK(new int[] {1,2,3}, 1)); // expect 0
    }
}
