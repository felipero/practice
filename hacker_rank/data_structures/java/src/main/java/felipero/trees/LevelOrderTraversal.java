/*
 * Solution for HackerRank problem Level Order Traversal:
 * check https://www.hackerrank.com/challenges/tree-level-order-traversal/problem
 */
package felipero.trees;

import java.util.*;
// import java.io.*;
import java.util.stream.Collectors;

class LevelOrderTraversal {

    public static List<Node> levelOrder(Node root) {
        List<Node> traversal = new ArrayList<Node>();

        List<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node nodeToProcess = queue.remove(0);

            if (nodeToProcess.left != null)
                queue.add(nodeToProcess.left);

            if (nodeToProcess.right != null)
                queue.add(nodeToProcess.right);

            traversal.add(nodeToProcess);
        }

        return traversal;
    }

    public static String printLevelOrder(Node root) {
        List<Node> nodes = levelOrder(root);
        return nodes.stream().map(Object::toString).collect(Collectors.joining(" "));
    }

    public static Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        } else {
            Node cur;
            if (value <= root.value) {
                cur = insert(root.left, value);
                root.left = cur;
            } else {
                cur = insert(root.right, value);
                root.right = cur;
            }
            return root;
        }
    }

    public static String execute(String input) {
        Scanner scan = new Scanner(input);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int value = scan.nextInt();
            root = insert(root, value);
        }
        scan.close();
        return printLevelOrder(root);
    }

    public static void main(String[] args) {
        String input = "6 \n 1 2 5 3 6 4";
        System.out.println(execute(input));
    }
}