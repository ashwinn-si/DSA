import java.util.Stack;

class Solution {
  public String removeKdigits(String num, int k) {
    int n = num.length();
    if (n == k)
      return "0";

    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < n; i++) {
      char c = num.charAt(i);
      while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
        stack.pop();
        k--;
      }
      stack.push(c);
    }

    while (k > 0 && !stack.isEmpty()) {
      stack.pop();
      k--;
    }

    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty())
      sb.append(stack.pop());
    sb.reverse();

    // Strip leading zeros
    int idx = 0;
    while (idx < sb.length() && sb.charAt(idx) == '0')
      idx++;
    String ans = idx == sb.length() ? "" : sb.substring(idx);

    return ans.isEmpty() ? "0" : ans;
  }
}
