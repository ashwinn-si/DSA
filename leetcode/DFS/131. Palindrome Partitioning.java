class Solution {
  List<List<String>> result;

  boolean isPalindrome(String str) {
    int mid = str.length() / 2;
    for (int index = 0; index < mid; index++) {
      if (str.charAt(index) != str.charAt(str.length() - 1 - index)) {
        return false;
      }
    }
    return true;
  }

  public void dfs(int pointer, String s, int N, List<String> currCombinations) {
    if (pointer == N) {
      result.add(new ArrayList<>(currCombinations));
      return;
    }
    for (int end = pointer; end < N; end++) {
      String part = (s.substring(pointer, end + 1));
      if (isPalindrome(part)) {
        currCombinations.add(part);
        dfs(end + 1, s, N, currCombinations);
        currCombinations.remove(currCombinations.size() - 1);
      }
    }
  }

  public List<List<String>> partition(String s) {
    result = new ArrayList<>();
    dfs(0, s, s.length(), new ArrayList<>());
    return result;
  }
}