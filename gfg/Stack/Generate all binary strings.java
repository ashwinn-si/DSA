class Solution {
  static List<String> result;

  static void dfs(StringBuffer string, int currIndex, int N, boolean prevDigitOneFlag) {
    if (currIndex == N) {
      result.add(string.toString());
      return;
    }

    string.append('0');
    dfs(string, currIndex + 1, N, false);
    string.deleteCharAt(string.length() - 1);

    if (!prevDigitOneFlag) {
      string.append('1');
      dfs(string, currIndex + 1, N, true);
      string.deleteCharAt(string.length() - 1);
    }

  }

  public static List<String> generateBinaryStrings(int N) {
    // code here
    result = new ArrayList<>();
    dfs(new StringBuffer(), 0, N, false);
    return result;
  }

}
