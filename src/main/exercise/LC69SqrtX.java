package exercise;

public class LC69SqrtX {
    public static int mySqrt(int x) {
        if (x < 2) return x;

        long left = 0;
        long right = x / 2;

        while (left <= right) {
            long a = left + (right - left) / 2;
            if (x > a * a) {
                left = a + 1;
            } else if (x < a * a) {
                right = a - 1;
            } else {
                return (int) a;
            }
        }
        return (int) right;
    }

    public static void main(String[] args) {
//        System.out.println(LC69SqrtX.mySqrt(2147395599)); // expect 46339
        System.out.println(LC69SqrtX.mySqrt(6));
    }
}
