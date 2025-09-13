class Solution {
  public int firstUniqChar(String s) {
    HashMap<Character, Integer> hash = new HashMap<>();
    for (char ch : s.toCharArray()) {
      hash.put(ch, hash.getOrDefault(ch, 0) + 1);
    }
    int index = 0;
    for (char ch : s.toCharArray()) {
      if (hash.get(ch) == 1) {
        return index;
      }
      index++;
    }
    return -1;
  }
}