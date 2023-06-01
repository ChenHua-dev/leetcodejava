package exercise;

import model.ListNode;

public class LC1721SwapNodes {

    public static ListNode swapNodes(ListNode head, int k) {
        if (head.next == null) return head;
        int n = 0;
        int c;
        ListNode temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        if (n <= 2) {
            ListNode rev = null;
            ListNode prev = head;
            ListNode curr = head;
            curr = curr.next;
            prev.next = rev;
            curr.next = prev;
            head = curr;
        } else {
            if (k > n) return null;
            c = n - k + 1;
            if (c == k) return head;
            if (k > c) {
                int temp_num = k;
                k = c;
                c = temp_num;
            }
            int temp_k = k;
            int temp_c = c;
            // k is index 1, complement is index 2
            ListNode ptr1 = head;
            ListNode ptr2 = head;
            int counter1 = 1;
            while (counter1 < temp_k - 1) {
                ptr1 = ptr1.next;
                counter1++;
            }
            int counter2 = 1;
            while (counter2 < temp_c - 1) {
                ptr2 = ptr2.next;
                counter2++;
            }
            if (k == 1) {
                ListNode dummyHead = new ListNode(1);
                dummyHead.next = ptr2.next;
                ptr2.next.next = ptr1.next;
                ptr2.next = ptr1;
                ptr1.next = null;
                return dummyHead.next;
            }
            if (Math.abs(temp_c - temp_k) > 2) {
                ListNode ptr3 = ptr2.next.next;
                ListNode ptr4 = ptr1.next.next;
                ListNode ptr5 = ptr1.next;

                ptr1.next.next = ptr3;
                ptr2.next.next = ptr4;
                ptr1.next = ptr2.next;
                ptr2.next = ptr5;
            } else if (Math.abs(temp_c - temp_k) > 1) { // == 2
                ptr1.next.next = ptr2.next.next;
                ptr2.next.next = ptr2;
                ptr2 = ptr2.next;
                ptr2.next.next = ptr1.next;
                ptr1.next = ptr2;
            } else { // == 1
                ptr1.next = ptr2.next;
                ptr2.next = ptr2.next.next;
                ptr1.next.next = ptr2;
            }
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode n1 = ListNode.createLLFromArray(new int[] {91, 56, 48, 77, 91, 96, 55, 53, 68});
        System.out.println(ListNode.displayLinkedList(n1));
        System.out.println(ListNode.displayLinkedList(LC1721SwapNodes.swapNodes(n1, 7)));
    }

}
