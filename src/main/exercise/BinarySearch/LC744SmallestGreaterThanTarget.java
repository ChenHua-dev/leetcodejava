package exercise.BinarySearch;

public class LC744SmallestGreaterThanTarget {
    public static char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (left == right && letters[left] > target) {
            return letters[left];
        } else {
            return letters[0];
        }
    }

    public static void main(String[] args) {
        System.out.println(nextGreatestLetter(new char[] {'c','f','j'}, 'a'));
        System.out.println(nextGreatestLetter(new char[] {'c','f','j'}, 'c'));
        System.out.println(nextGreatestLetter(new char[] {'x','x','y','y'}, 'z'));
    }
}
