package felipero.trees;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SwapNodesTest {
    @Test
    void testSwapNodesInOrderTraversal() {
        String input = "3\n2 3\n-1 -1\n-1 -1\n2\n1\n1";
        assertEquals("3 1 2\n2 1 3", SwapNodes.execute(input));
    }

    @Test
    void testSwapNodes_with_5_nodes() {
        String input = "5\n2 3\n-1 4\n-1 5\n-1 -1\n-1 -1\n1\n2";

        assertEquals("4 2 1 5 3", SwapNodes.execute(input));
    }

    @Test
    void testSwapNodes_with_11_nodes() {
        String input = "11\n2 3\n4 -1\n5 -1\n6 -1\n7 8\n-1 9\n-1 -1\n10 11\n-1 -1\n-1 -1\n-1 -1\n2\n2\n4";
        assertEquals("2 9 6 4 1 3 7 5 11 8 10\n2 6 9 4 1 3 7 5 10 8 11", SwapNodes.execute(input));
    }
}