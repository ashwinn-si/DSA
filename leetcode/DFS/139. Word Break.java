class Solution {
  Boolean memo[];
  boolean isFound;

  private boolean dfs(int pointer, String s, List<String> wordDict) {
    if (pointer == s.length()) {
      isFound = true;
      return true;
    }
    if (memo[pointer] != null) {
      return memo[pointer];
    }
    boolean result = false;
    for (String str : wordDict) {
      int length = str.length();
      if (pointer + length > s.length()) {
        continue;
      }
      if (s.substring(pointer, pointer + length).equals(str)) {
        result |= dfs(pointer + length, s, wordDict);
      }
    }
    memo[pointer] = result;
    return memo[pointer];
  }

  public boolean wordBreak(String s, List<String> wordDict) {
    int N = s.length();
    memo = new Boolean[N];
    isFound = false;
    dfs(0, s, wordDict);
    return isFound;
  }
}