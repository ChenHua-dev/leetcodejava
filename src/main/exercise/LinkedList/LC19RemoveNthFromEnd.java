package exercise.LinkedList;

import model.ListNode;

public class LC19RemoveNthFromEnd {
    public static ListNode removeNthFromEnd (ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        int pos = len - n + 1;
        int counter = 0;
        temp = dummy;
        while (counter < pos - 1) {
            temp = temp.next;
            counter++;
        }
        temp.next = temp.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode h1 = ListNode.createLLFromArray(new int[] {1,2,3,4,5});
        ListNode h2 = ListNode.createLLFromArray(new int[] {1});
        ListNode h3 = ListNode.createLLFromArray(new int[] {1,2});
        ListNode h4 = ListNode.createLLFromArray(new int[] {1,2,3,4,5,6});
        System.out.println(ListNode.displayLinkedList(removeNthFromEnd(h1, 1)));
        System.out.println(ListNode.displayLinkedList(removeNthFromEnd(h2, 1)));
        System.out.println(ListNode.displayLinkedList(removeNthFromEnd(h3, 1)));
        System.out.println(ListNode.displayLinkedList(removeNthFromEnd(h4, 1)));
    }
}
