package exercise.LinkedList;

import model.ListNode;

public class LC876MiddleLinkedList {
    public static ListNode middleNode (ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head1 = ListNode.createLLFromArray(new int[] {1,2,3,4,5});
        ListNode head2 = ListNode.createLLFromArray(new int[] {1,2,3,4,5,6});
        System.out.println(ListNode.displayLinkedList(middleNode(head1)));
        System.out.println(ListNode.displayLinkedList(middleNode(head2)));
    }

}
