class Solution {
  public int longestPalindrome(String s) {
    HashMap<Character, Integer> hash = new HashMap<>();
    for (char ch : s.toCharArray()) {
      hash.put(ch, hash.getOrDefault(ch, 0) + 1);
    }
    int possibleLength = 0;
    int oneOcc = 0;
    for (char key : hash.keySet()) {
      int occ = hash.get(key);
      if (occ % 2 == 0) {
        possibleLength += occ;
      } else {
        possibleLength += (occ - 1);
        oneOcc++;
      }
    }
    if (oneOcc > 0) {
      possibleLength++;
    }
    return possibleLength;
  }
}