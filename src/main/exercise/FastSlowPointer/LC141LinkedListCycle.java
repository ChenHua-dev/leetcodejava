package exercise.FastSlowPointer;

import model.ListNode;

public class LC141LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;

        // 1st check fast != null, not: fast.next != null && fast.next.next != null
        // b/c if head is [], then fast.next would throw null pointer exception
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
