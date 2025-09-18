class Solution {
  public String infixToPostfix(String str) {
    // Your code goes here
    Stack<Character> stack = new Stack();
    StringBuffer result = new StringBuffer();
    HashMap<Character, Integer> hash = new HashMap<>();
    hash.put('+', 1);
    hash.put('-', 1);
    hash.put('*', 2);
    hash.put('/', 2);
    hash.put('%', 2);
    hash.put('^', 3);
    hash.put('(', 0);
    hash.put(')', 0);
    for (int index = 0; index < str.length(); index++) {
      char ch = str.charAt(index);
      if (Character.isLetterOrDigit(ch)) {
        result.append(ch);
      } else if (ch == '(') {
        stack.push(ch);
      } else if (ch == ')') {
        while (!stack.isEmpty() && stack.peek() != '(') {
          result.append(stack.pop());
        }
        stack.pop();
      } else {
        while (!stack.isEmpty() &&
            ((ch != '^' && hash.get(stack.peek()) >= hash.get(ch)) ||
                (ch == '^' && hash.get(stack.peek()) > hash.get(ch)))) {
          result.append(stack.pop());
        }
        stack.push(ch);
      }
    }
    while (!stack.isEmpty()) {
      result.append(stack.pop());
    }
    return result.toString();
  }
}
