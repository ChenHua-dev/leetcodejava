package exercise;

import model.ListNode;

public class LC142LinkedListCycle2 {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) break;
        }

        if (fast == null || fast.next == null) return null;

        ListNode seek = head;
        while (seek != slow) {
            seek = seek.next;
            slow = slow.next;
        }

        return seek;
    }

}
