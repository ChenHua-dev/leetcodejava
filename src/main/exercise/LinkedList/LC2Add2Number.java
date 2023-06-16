package exercise.LinkedList;

import model.ListNode;

public class LC2Add2Number {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // create dummy head
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
        int x, y = 0;
        int sum;

        while (l1 != null || l2 != null || carry != 0) {
            x = (l1 != null) ? l1.val : 0;
            y = (l2 != null) ? l2.val : 0;

            sum = x + y + carry;
            ListNode temp = new ListNode(sum % 10);
            // update carry
            carry = sum / 10;
            // update curr
            curr.next = temp;
            curr = curr.next;
            // move l1 and l2
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {

    }
}
