package exercise;

import exercise.LinkedList.LC2Add2Number;
import model.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LC2Add2NumberTest {
    private LC2Add2Number s;

    @BeforeEach
    void setUp() { s = new LC2Add2Number(); }

    @Test
    void testCase1() {
        ListNode n1 = new ListNode(9);
        ListNode n2 = new ListNode(9);
        ListNode n3 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        ListNode l1 = n1;

        ListNode n4 = new ListNode(6);
        ListNode n5 = new ListNode(5);
        n4.next = n5;
        ListNode l2 = n4;

        ListNode res = s.addTwoNumbers(l1, l2);
        String str = ListNode.displayLinkedList(res);
        System.out.println(str);
    }
}
