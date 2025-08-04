class Solution {
  List<String> result;

  void dfs(int open, int close, int N, StringBuffer string) {
    if (open == N && close == N) {
      result.add(string.toString());
      return;
    }
    if (open < N) {
      string.append("(");
      dfs(open + 1, close, N, string);
      string.deleteCharAt(string.length() - 1);
    }
    if (open > close) {
      string.append(")");
      dfs(open, close + 1, N, string);
      string.deleteCharAt(string.length() - 1);
    }
  }

  public List<String> generateParenthesis(int N) {
    result = new ArrayList<>();
    dfs(0, 0, N, new StringBuffer());
    return result;
  }
}