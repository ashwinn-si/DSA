public class Solution {
  List<Integer> dfs(int left, int right, String str) {
    List<Integer> result = new ArrayList<>();

    for (int index = left; index < right + 1; index++) {
      char ch = str.charAt(index);
      if (ch == '+' || ch == '-' || ch == '*') {
        List<Integer> leftElement = dfs(left, index - 1, str);
        List<Integer> rightElement = dfs(index + 1, right, str);

        for (int a : leftElement) {
          for (int b : rightElement) {
            if (ch == '+') {
              result.add(a + b);
            } else if (ch == '-') {
              result.add(a - b);
            } else {
              result.add(a * b);
            }
          }
        }
      }
    }
    if (result.size() == 0) {
      result.add(Integer.parseInt(str.substring(left, right + 1)));
    }
    return result;
  }

  public List<Integer> diffWaysToCompute(String expression) {
    return dfs(0, expression.length() - 1, expression);
  }
}
