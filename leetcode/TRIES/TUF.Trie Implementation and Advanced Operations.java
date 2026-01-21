class Trie {
  Node head;

  public Trie() {
    this.head = new Node();
  }

  void insert(String str) {
    Node node = head;
    for (char ch : str.toCharArray()) {
      int charIndex = ch - 'a';
      if (node.links[charIndex] == null) {
        node.links[charIndex] = new Node();
      }
      node = node.links[charIndex];
      node.incPC();
    }
    node.incEC();
  }

  public int countWordsEqualTo(String str) {
    Node node = head;
    for (char ch : str.toCharArray()) {
      int charIndex = ch - 'a';
      if (node.links[charIndex] == null) {
        return 0;
      }
      node = node.links[charIndex];
    }
    return node.endCount;
  }

  public int countWordsStartingWith(String str) {
    Node node = head;
    for (char ch : str.toCharArray()) {
      int charIndex = ch - 'a';
      if (node.links[charIndex] == null) {
        return 0;
      }
      node = node.links[charIndex];
    }
    return node.prefixCount;
  }

  public void erase(String str) {
    int wordsStartWith = countWordsStartingWith(str);
    if (wordsStartWith == 0) {
      return;
    }
    Node node = head;
    for (char ch : str.toCharArray()) {
      int charIndex = ch - 'a';
      node = node.links[charIndex];
      node.decPC();
    }
    node.decEC();
  }
}

class Node {
  Node[] links;
  int prefixCount;
  int endCount;

  Node() {
    this.prefixCount = 0;
    this.endCount = 0;
    links = new Node[26];
  }

  void incEC() {
    this.endCount++;
  }

  void incPC() {
    this.prefixCount++;
  }

  void decPC() {
    this.prefixCount--;
  }

  void decEC() {
    this.endCount--;
  }
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie();
 * obj.insert(word); int param_2 = obj.countWordsEqualTo(word); int param_3 =
 * obj.countWordsStartingWith(prefix); obj.erase(word);
 */
