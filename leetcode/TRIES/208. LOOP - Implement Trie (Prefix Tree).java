class Trie {
  Node head;

  public Trie() {
    head = new Node();
  }

  public void insert(String str) {
    Node node = head;
    for (char ch : str.toCharArray()) {
      int charIndex = ch - 'a';
      if (node.links[charIndex] == null) {
        node.links[charIndex] = new Node();
      }
      node = node.links[charIndex];
    }
    node.setAsEnd();
  }

  public boolean search(String str) {
    Node node = head;
    for (char ch : str.toCharArray()) {
      int charIndex = ch - 'a';
      if (node.links[charIndex] == null) {
        return false;
      }
      node = node.links[charIndex];
    }
    return node.flag;
  }

  public boolean startsWith(String str) {
    Node node = head;
    for (char ch : str.toCharArray()) {
      int charIndex = ch - 'a';
      if (node.links[charIndex] == null) {
        return false;
      }
      node = node.links[charIndex];
    }
    return true;
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