class Trie {
  Node head;

  public Trie() {
    head = new Node();
  }

  private void insertHelper(int index, String str, Node node) {
    if (index == str.length()) {
      node.setAsEnd();
      return;
    }
    int charIndex = str.charAt(index) - 'a';
    if (node.links[charIndex] == null) {
      node.links[charIndex] = new Node();
    }
    insertHelper(index + 1, str, node.links[charIndex]);
  }

  public void insert(String str) {
    insertHelper(0, str, head);
  }

  private boolean searchHelper(int index, String str, Node node) {
    if (index == str.length()) {
      return node.flag;
    }
    int charIndex = str.charAt(index) - 'a';
    if (node.links[charIndex] == null) {
      return false;
    }
    return searchHelper(index + 1, str, node.links[charIndex]);
  }

  public boolean search(String str) {
    return searchHelper(0, str, head);
  }

  private boolean startsWithHelper(int index, String str, Node node) {
    if (index == str.length()) {
      return true;
    }
    int charIndex = str.charAt(index) - 'a';
    if (node.links[charIndex] == null) {
      return false;
    }
    return startsWithHelper(index + 1, str, node.links[charIndex]);
  }

  public boolean startsWith(String str) {
    return startsWithHelper(0, str, head);
  }
}

class Node {
  Node[] links = new Node[26];
  boolean flag;

  Node() {
    this.flag = false;
  }

  void setAsEnd() {
    this.flag = true;
  }
}