/*
 * Solution for HackerRank problem Balanced Brackets:
 * check https://www.hackerrank.com/challenges/balanced-brackets/problem
 */
package felipero.stacks;

import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

  static String isBalanced(String s) {
    Stack<Character> stack = new Stack<Character>();
    Map<Character, Character> bracketsMap = Map.of('{', '}', '[', ']', '(', ')');

    for (Character c : s.toCharArray()) {
      if ("{[(".contains(c.toString()))
        stack.push(c);
      else {
        if (stack.isEmpty() || bracketsMap.get(stack.pop()) != c)
          return "NO";
      }
    }

    return stack.isEmpty() ? "YES" : "NO";
  }

  public static String execute(String input) {
    Scanner scanner = new Scanner(input);

    int t = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    String output = "";
    for (int tItr = 0; tItr < t; tItr++) {
      String s = scanner.nextLine();

      String result = isBalanced(s);

      output += result;
      output += scanner.hasNext() ? "\n" : "";
    }

    scanner.close();

    return output;
  }
}
