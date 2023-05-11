package exercise;

import model.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LC83RemoveAllDuplicateTest {
    private LC83RemoveAllDuplicate s;

    @BeforeEach
    void setUp() { s = new LC83RemoveAllDuplicate(); }

    @Test
    void testSingleDelete() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        ListNode head = n1;
        System.out.println(ListNode.displayLinkedList(head));
    }
}
