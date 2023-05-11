package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ListNodeTest {
    ListNode node;

    @BeforeEach
    void setUp() { node = new ListNode(1); }

    @Test
    void testConstructor() {
        assertEquals(1, node.val);
    }
}