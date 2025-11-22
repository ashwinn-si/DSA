class Solution {
  public int countPalindromicSubsequence(String s) {
    int result = 0;
    for (char ch = 'a'; ch <= 'z'; ch++) {
      int firstIndex = s.indexOf(ch);
      int lastIndex = s.lastIndexOf(ch);
      if (firstIndex != -1 && firstIndex + 1 < lastIndex) {
        HashSet<Character> hash = new HashSet<>();
        for (int index = firstIndex + 1; index < lastIndex; index++) {
          hash.add(s.charAt(index));
        }
        result += hash.size();
      }
    }
    return result;
  }
}