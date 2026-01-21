class Trie {
  Node headNode;

  Trie() {
    headNode = new Node();
  }

  boolean insert(String str) {
    if (str.length() == 1) {
      int charIndex = str.charAt(0) - 'a';
      if (headNode.links[charIndex] == null) {
        headNode.links[charIndex] = new Node();
      }
      headNode.endFlag = true;
      return true;
    }
    int noPrefixFound = 0;
    Node curr = headNode;
    for (char ch : str.toCharArray()) {
      int charIndex = ch - 'a';
      if (curr.links[charIndex] == null) {
        curr.links[charIndex] = new Node();
      }
      if (curr.endFlag) {
        noPrefixFound++;
      }
      curr = curr.links[charIndex];
    }
    curr.endFlag = true;

    return noPrefixFound >= str.length() - 1;
  }
}

class Node {
  Node[] links;
  boolean endFlag;

  Node() {
    links = new Node[26];
    endFlag = false;
  }
}

class Solution {
  public String completeString(List<String> strings) {
    // your code goes here
    Collections.sort(strings);
    Trie trie = new Trie();
    String result = "";
    for (String str : strings) {
      if (trie.insert(str)) {
        if (str.length() > result.length()) {
          result = str;
        }
      }
    }
    return result.equals("") ? "None" : result;
  }
}