/*
 * Solution for HackerRank problem Swap Nodes [Algo]:
 * check https://www.hackerrank.com/challenges/swap-nodes-algo/problem
 */
package felipero.trees;

import java.io.*;
// import java.math.*;
// import java.text.*;
import java.util.*;
// import java.util.regex.*;

public class SwapNodes {

  private static Node mountTreeFromIndexes(int[][] indexes) {
    Node root = new Node(1);
    Queue<Node> nodesToProcess = new LinkedList<Node>();
    nodesToProcess.add(root);

    for (int[] line : indexes) {
      Node parent = nodesToProcess.remove();

      int valueLeft = line[0];
      int valueRight = line[1];

      if (valueLeft != -1) {
        parent.left = new Node(valueLeft);
        nodesToProcess.add(parent.left);
      }

      if (valueRight != -1) {
        parent.right = new Node(valueRight);
        nodesToProcess.add(parent.right);
      }
    }

    return root;
  }

  private static void swapLevelOperation(Node root, int k) {
    swapLevelOperation(root, k, 1);
  }

  private static void swapLevelOperation(Node parent, int k, int level) {

    if (parent.left != null)
      swapLevelOperation(parent.left, k, level + 1);

    if (parent.right != null)
      swapLevelOperation(parent.right, k, level + 1);

    if (level % k == 0) {
      Node tempLeft = parent.left;
      parent.left = parent.right;
      parent.right = tempLeft;
    }
  }

  private static List<Integer> inOrderTraverseTree(Node root) {
    List<Integer> result = new LinkedList<Integer>();

    if (root.left != null) {
      List<Integer> left = inOrderTraverseTree(root.left);
      result.addAll(left);
    }

    result.add(root.value);

    if (root.right != null) {
      List<Integer> right = inOrderTraverseTree(root.right);
      result.addAll(right);
    }

    return result;
  }

  static int[][] swapNodes(int[][] indexes, int[] queries) {
    Node root = mountTreeFromIndexes(indexes);

    int[][] results = new int[queries.length][];

    for (int i = 0; i < queries.length; ++i) {
      swapLevelOperation(root, queries[i]);
      List<Integer> swapedTree = inOrderTraverseTree(root);
      results[i] = swapedTree.stream().mapToInt(item -> item).toArray();
    }

    return results;
  }

  // O(n + t*(3*2n+1)) =
  // 1: 3 + 2*(7) = 17 --> Worst case: 3 + 2*(6*3+1) = 41

  // Combinando as operações de Swap, Traverse e Conversão para array
  // O(n + 2*(2n)) =
  // 1: 3 + 2(6) = 15 --> Worst case: 3 + 2(8) = 19

  public static String execute(String input) {

    Scanner scanner = new Scanner(input);
    int n = Integer.parseInt(scanner.nextLine().trim());

    int[][] indexes = new int[n][2];

    for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
      String[] indexesRowItems = scanner.nextLine().split(" ");

      for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
        int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
        indexes[indexesRowItr][indexesColumnItr] = indexesItem;
      }
    }

    int queriesCount = Integer.parseInt(scanner.nextLine().trim());

    int[] queries = new int[queriesCount];

    for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
      int queriesItem = Integer.parseInt(scanner.nextLine().trim());
      queries[queriesItr] = queriesItem;
    }

    scanner.close();

    int[][] result = swapNodes(indexes, queries);

    String output = "";
    for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
      for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
        output += String.valueOf(result[resultRowItr][resultColumnItr]);

        if (resultColumnItr != result[resultRowItr].length - 1) {
          output += " ";
        }
      }

      if (resultRowItr != result.length - 1) {
        output += "\n";
      }
    }

    return output;
  }

  public static void main(String[] args) throws IOException {
    String input = "3\n2 3\n-1 -1\n-1 -1\n2\n1\n1";
    System.out.println(execute(input));
  }
}
