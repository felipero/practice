package felipero.tries;

import java.io.IOException;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

class TrieNode {
  Map<Character, TrieNode> children;
  Character value;
  Boolean complete;

  TrieNode(Character value) {
    this.value = value;
    this.children = new HashMap<Character, TrieNode>();
    this.complete = false;
  }

  public Boolean isComplete() {
    return this.complete;
  }

  @Override
  public boolean equals(Object other) {
    return this.value.equals(((TrieNode) other).value);
  }

  @Override
  public int hashCode() {
    int result = 211 + 109 + ((value == null) ? 0 : value.hashCode());
    return result;
  }
}

class Contacts {

  static void add(Map<Character, TrieNode> children, List<Character> nameChars) {
    Character key = nameChars.remove(0);

    TrieNode node = children.get(key);

    if (node == null) {
      node = new TrieNode(key);
      children.put(key, node);
    }

    if (!nameChars.isEmpty())
      add(node.children, nameChars);
    else
      node.complete = true;
  }

  static Integer find(Map<Character, TrieNode> trie, List<Character> nameChars) {
    Integer count = 0;

    if (!nameChars.isEmpty()) {
      Character key = nameChars.remove(0);
      TrieNode node = trie.get(key);
      if (node == null)
        return 0;

      if (nameChars.isEmpty() && node.isComplete())
        count += 1;

      count += find(node.children, nameChars);

    } else {
      for (Entry<Character, TrieNode> entry : trie.entrySet()) {
        TrieNode node = entry.getValue();

        if (node.isComplete())
          count += 1;

        count += find(node.children, nameChars);
      }
    }

    return count;
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