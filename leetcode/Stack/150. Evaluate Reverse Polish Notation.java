class Solution {
  int performOperation(char ch, int num2, int num1) {
    if (ch == '+') {
      return num1 + num2;
    }
    if (ch == '-') {
      return num1 - num2;
    }
    if (ch == '*') {
      return num1 * num2;
    }
    return num1 / num2;
  }

  public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();
    for (String str : tokens) {
      char ch = str.charAt(0);
      if ((ch == '+' || ch == '-' || ch == '*' || ch == '/') && str.length() == 1) {
        stack.push(performOperation(ch, stack.pop(), stack.pop()));
      } else {
        stack.push(Integer.parseInt(str));
      }
    }
    return stack.pop();
  }
}