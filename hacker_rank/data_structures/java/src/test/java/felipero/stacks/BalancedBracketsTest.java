package felipero.stacks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BalancedBracketsTest {
  @Test
  void testIsBalanced() {
    StringBuffer input = new StringBuffer("3\n");
    input.append("{[()]}\n");
    input.append("{[(])}\n");
    input.append("{{[[(())]]}}");

    assertEquals("YES\nNO\nYES", BalancedBrackets.execute(input.toString()));
  }

  @Test
  void testIsBalanced_with_only_unbalanced() {
    StringBuffer input = new StringBuffer("1\n");
    input.append("{[(])}\n");

    assertEquals("NO", BalancedBrackets.execute(input.toString()));
  }

  @Test
  void testIsBalanced_with_some_unbalanced() {
    StringBuffer input = new StringBuffer("6\n");
    input.append("}][}}(}][))]\n");
    input.append("[](){()}\n");
    input.append("()\n");
    input.append("({}([][]))[]()\n");
    input.append("{)[](}]}]}))}(())(\n");
    input.append("([[)");

    assertEquals("NO\nYES\nYES\nYES\nNO\nNO", BalancedBrackets.execute(input.toString()));
  }
}