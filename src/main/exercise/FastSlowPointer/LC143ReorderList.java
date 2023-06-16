package exercise.FastSlowPointer;

import model.ListNode;


public class LC143ReorderList {

    private static ListNode traverseBeforeTail(ListNode head) {
        ListNode tail = head;
        while (tail.next.next != null) {
            tail = tail.next;
        }
        return tail;
    }

    public static void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            ListNode beforeTail = traverseBeforeTail(head);
            ListNode temp = fast.next;
            fast.next = beforeTail.next;
            beforeTail.next.next = temp;
            beforeTail.next = null;
            // update the slow and fast pointer
            slow = slow.next;
            fast = fast.next.next;
        }
    }

    public static void main(String[] args) {
//        ListNode head = ListNode.createLLFromArray(new int[] {0, 1, 2, 3, 4, 5});
//        ListNode head = ListNode.createLLFromArray(new int[] {2, 4, 6, 8, 10, 12});
        ListNode head = ListNode.createLLFromArray(new int[] {0, 1, 2, 3, 4});
        reorderList(head);
        System.out.println(ListNode.displayLinkedList(head));
        System.out.println();
    }

}
