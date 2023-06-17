package exercise.LinkedList;

import model.ListNode;

public class LC61RotateList {
    public static ListNode rotateOnce (ListNode head) {
        ListNode dummy = new ListNode(-999);
        dummy.next = head;
        ListNode beforeTail;
        beforeTail = head;
        while (beforeTail.next.next != null) {
            beforeTail = beforeTail.next;
        }
        beforeTail.next.next = dummy.next;
        dummy.next = beforeTail.next;
        beforeTail.next = null;
        return dummy.next;
    }

    public static ListNode rotateRight (ListNode head, int k) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        if (len < 2) return head;
        int newK = k % len;
        while (newK != 0) {
            head = rotateOnce(head);
            newK--;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode h1 = ListNode.createLLFromArray(new int[] {1,2,3,4,5});
        ListNode h2 = ListNode.createLLFromArray(new int[] {0,1,2});
        ListNode h3 = ListNode.createLLFromArray(new int[] {});
        System.out.println(ListNode.displayLinkedList(rotateRight(h1, 2)));
        System.out.println(ListNode.displayLinkedList(rotateRight(h2, 4)));
        System.out.println(ListNode.displayLinkedList(rotateRight(h3, 1)));
    }
}
