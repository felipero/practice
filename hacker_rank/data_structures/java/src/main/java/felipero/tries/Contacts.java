package felipero.tries;

import java.io.IOException;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class TrieNode {
  Character value;
  Boolean complete;
  Integer count;
  Map<Character, TrieNode> children;

  TrieNode(Character value) {
    this.value = value;
    this.children = new HashMap<Character, TrieNode>();
    this.complete = false;
    this.count = 0;
  }

  public Boolean isComplete() {
    return this.complete;
  }
}

class Contacts {

  static void add(Map<Character, TrieNode> children, List<Character> nameChars) {
    Character key = nameChars.remove(0);

    TrieNode currentNode = children.get(key);

    if (currentNode == null) {
      currentNode = new TrieNode(key);
      children.put(key, currentNode);
    }

    currentNode.count++;
    if (!nameChars.isEmpty())
      add(currentNode.children, nameChars);
    else
      currentNode.complete = true;
  }

  static Integer find(Map<Character, TrieNode> trie, List<Character> partialChars) {
    if (!partialChars.isEmpty()) {
      Character key = partialChars.remove(0);
      TrieNode node = trie.get(key);
      if (node == null)
        return 0;

      if (partialChars.isEmpty())
        return node.count;

      return find(node.children, partialChars);
    }
    return 0;
  }

  static int[] contacts(String[][] queries) {
    Map<Character, TrieNode> trie = new HashMap<Character, TrieNode>();

    List<Integer> found = new ArrayList<Integer>();

    for (String[] op : queries) {
      String command = op[0];
      String name = op[1];
      List<Character> nameChars = name.chars().mapToObj(e -> (Character) (char) e).collect(Collectors.toList());

      if (command.equals("add")) {
        add(trie, nameChars);
      } else {
        found.add(find(trie, nameChars));
      }
    }
    return found.stream().mapToInt(item -> item).toArray();
  }

  public static String execute(String input) {
    Scanner scanner = new Scanner(input);

    int queriesRows = Integer.parseInt(scanner.nextLine().trim());

    String[][] queries = new String[queriesRows][2];

    for (int queriesRowItr = 0; queriesRowItr < queriesRows; queriesRowItr++) {
      String[] queriesRowItems = scanner.nextLine().split(" ");

      for (int queriesColumnItr = 0; queriesColumnItr < 2; queriesColumnItr++) {
        String queriesItem = queriesRowItems[queriesColumnItr];
        queries[queriesRowItr][queriesColumnItr] = queriesItem;
      }
    }
    scanner.close();

    int[] result = contacts(queries);

    String output = "";
    for (int resultItr = 0; resultItr < result.length; resultItr++) {
      output += String.valueOf(result[resultItr]);

      if (resultItr != result.length - 1) {
        output += "\n";
      }
    }

    return output;
  }

  public static void main(String[] args) throws IOException {
    StringBuffer input = new StringBuffer("4\n");
    input.append("add felipe\n");
    input.append("add felipero\n");
    input.append("find fel\n");
    input.append("find fero");

    System.out.println(execute(input.toString()));
  }
}