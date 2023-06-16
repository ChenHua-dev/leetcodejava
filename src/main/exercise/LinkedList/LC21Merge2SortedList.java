package exercise.LinkedList;

import model.ListNode;

public class LC21Merge2SortedList {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(1);
        ListNode temp = dummyHead;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        while (list1 != null) {
            temp.next = list1;
            list1 = list1.next;
            temp = temp.next;
        }
        while (list2 != null) {
            temp.next = list2;
            list2 = list2.next;
            temp = temp.next;
        }
        return dummyHead.next;
    }


    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;

        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(3);
//        ListNode n6 = new ListNode(4);
        n4.next = n5;
//        n5.next = n6;
        System.out.println(ListNode.displayLinkedList(LC21Merge2SortedList.mergeTwoLists(n1, n4)));
    }

}
