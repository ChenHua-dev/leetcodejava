package exercise;

public class LC457CircularArrLoop {

    private static int getNext(int[] nums, int index) {
        int n = nums.length;
        int next = (index + nums[index]) % n;

        if (next >= 0) return next;
        else return next + nums.length;
    }

    public static boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        if (n < 2) return false;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;

            int slow = i; // slow index
            int fast = i; // fast index

            // loop condition:
            while (true) {
                if (slow == getNext(nums, slow)) break;
                if (nums[slow] * nums[getNext(nums, slow)] < 0) break;
                slow = getNext(nums, slow);

                if (fast == getNext(nums, fast)) break;
                if (nums[fast] * nums[getNext(nums, fast)] < 0) break;
                fast = getNext(nums, fast);

                if (fast == getNext(nums, fast)) break;
                if (nums[fast] * nums[getNext(nums, fast)] < 0) break;
                fast = getNext(nums, fast);

                if (slow == fast) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(circularArrayLoop(new int[] {2, -1, 1, 2, -1}));
        System.out.println(circularArrayLoop(new int[] {-2, -1, 1, -2, -1}));
        System.out.println(circularArrayLoop(new int[] {2, -1, 1, -2, -1}));
        System.out.println(circularArrayLoop(new int[] {4, 1, 1, 1}));
        System.out.println(circularArrayLoop(new int[] {2, 1, -1, 1}));
        System.out.println(circularArrayLoop(new int[] {1, 1, 2, 1, 2}));
    }
}
