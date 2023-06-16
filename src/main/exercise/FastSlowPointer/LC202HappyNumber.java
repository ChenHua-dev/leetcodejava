package exercise.FastSlowPointer;

public class LC202HappyNumber {

    private static int sumOfSquare(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }

    public static boolean isHappy(int n) {
        if (n == 1) return true;
        int slow = n;
        int fast = n;

        while (fast != 1) {
            slow = sumOfSquare(slow);

            fast = sumOfSquare(fast);
            fast = sumOfSquare(fast);
            if (slow == 1) return true;
            else if (slow == fast) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
        System.out.println(isHappy(2));
        System.out.println(isHappy(10));
    }

}
