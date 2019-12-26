package felipero.trees;

class Node {
  Node left;
  Node right;
  int value;

  Node(int value) {
    this.value = value;
    left = null;
    right = null;
  }

  public String toString() {
    return String.valueOf(this.value);
  }
}