package exercise.LinkedList;

import model.ListNode;

public class LC92ReverseList2 {

    public static ListNode reverseBetween (ListNode head, int left, int right) {
        if (left == right) return head;
        ListNode dummyHead = new ListNode(-999);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        int counter = left - 1;
        while (counter != 0) {
            prev = prev.next;
            counter--;
        }
        counter = right - left;
        ListNode fix = prev.next;
        while (counter != 0) {
            ListNode temp = prev.next;
            prev.next = fix.next;
            fix.next = fix.next.next;
            prev.next.next = temp;
            counter--;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode h1 = ListNode.createLLFromArray(new int[] {1,2,3,4,5,6,7,8,9,10});
        ListNode h2 = ListNode.createLLFromArray(new int[] {5});
        ListNode h3 = ListNode.createLLFromArray(new int[] {3,5});
        System.out.println(ListNode.displayLinkedList(reverseBetween(h1, 5, 10)));
        System.out.println(ListNode.displayLinkedList(reverseBetween(h2, 5, 5)));
        System.out.println(ListNode.displayLinkedList(reverseBetween(h3, 1, 2)));

    }
}
