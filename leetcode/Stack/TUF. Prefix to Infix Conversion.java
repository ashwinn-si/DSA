class Solution {
  public String prefixToInfix(String str) {
    // Your code goes here
    Stack<StringBuffer> stack = new Stack();
    for (int index = str.length() - 1; index >= 0; index--) {
      char ch = str.charAt(index);
      if (Character.isLetterOrDigit(ch)) {
        stack.push(new StringBuffer(String.valueOf(ch)));
      } else {
        StringBuffer currEqu = new StringBuffer();
        currEqu.append('(');
        currEqu.append(ch);
        currEqu.append(')');
        currEqu.insert(1, stack.pop());
        currEqu.insert(currEqu.length() - 1, stack.pop());
        stack.push(currEqu);
      }
    }
    return (stack.pop().toString());
  }
}
