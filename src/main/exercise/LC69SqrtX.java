package exercise;

public class LC69SqrtX {
    public static int mySqrt(int x) {
        if (x < 2) return x;
        long left = 0;
        long right = x / 2;
        long squared;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            squared = mid * mid; // squared = f(mid)
            if (x > squared) { // x is like your target, target > mid => left = mid + 1
                left = mid + 1 ;
            } else if (x < squared) {
                right = mid - 1;
            } else {
                return (int) mid;
            }
        }
        // right < left => return right b/c question requires us to return floored value
        return (int) right;
    }

    public static void main(String[] args) {
        System.out.println(LC69SqrtX.mySqrt(2147395599));
    }
}
