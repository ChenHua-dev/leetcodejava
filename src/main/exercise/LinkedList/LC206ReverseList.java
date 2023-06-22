package exercise.LinkedList;

import model.ListNode;

public class LC206ReverseList {

    public static ListNode reverseList(ListNode head) {
        ListNode revHead = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = revHead;
            revHead = curr;
            curr = temp;
        }
        return revHead;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode head = n1;
        ListNode h3 = ListNode.createLLFromArray(new int[] {3,5});
        System.out.println(ListNode.displayLinkedList(head));
        System.out.println(ListNode.displayLinkedList(LC206ReverseList.reverseList(head)));
        System.out.println(ListNode.displayLinkedList(LC206ReverseList.reverseList(h3)));
    }

}
