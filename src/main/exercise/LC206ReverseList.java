package exercise;

import model.ListNode;

public class LC206ReverseList {

    public static ListNode reverseList(ListNode head) {
        ListNode revHead = null;
        ListNode curr = head;
        ListNode temp = null;

        while (curr != null) {
            temp = curr.next;
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
        System.out.println(ListNode.displayLinkedList(head));
        System.out.println(ListNode.displayLinkedList(LC206ReverseList.reverseList(head)));
    }

}
