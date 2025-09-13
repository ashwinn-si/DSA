class Solution {
  public static boolean areAnagrams(String s1, String s2) {
    // code here
    if (s1.length() != s2.length()) {
      return false;
    }
    HashMap<Character, Integer> hash = new HashMap<>();

    for (char ch : s1.toCharArray()) {
      hash.put(ch, hash.getOrDefault(ch, 0) + 1);
    }

    for (char ch : s2.toCharArray()) {
      if (hash.get(ch) == null) {
        return false;
      }
      if (hash.get(ch) == 0) {
        return false;
      }
      hash.put(ch, hash.get(ch) - 1);
    }
    return true;
  }
}