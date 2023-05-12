package exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LC14LongestCommPrefTest {
    private LC14LongestCommPref s;

    @BeforeEach
    void setUp() { s = new LC14LongestCommPref(); }

    @Test
    void testCase1() {
        String[] strs = new String[]{"flower", "flow", "flight"};
        String prefix = s.longestCommonPrefix(strs);
        System.out.println(prefix);
//        assertEquals("fl", prefix);
    }

    @Test
    void testCase2() {
        String[] strs = new String[]{"c", "acc", "ccc"};
        String prefix = s.longestCommonPrefix(strs);
        System.out.println(prefix);
//        assertEquals("fl", prefix);
    }


}
