import java.util.*;

class Solution {
  public String prefixToPostfix(String str) {
    // Your code goes here
    Stack<StringBuffer> stack = new Stack<>();
    for (int index = str.length() - 1; index >= 0; index--) {
      char ch = str.charAt(index);
      if (Character.isLetterOrDigit(ch)) {
        stack.push(new StringBuffer(String.valueOf(ch)));
      } else {
        StringBuffer currEqu = new StringBuffer();
        currEqu.append(ch);
        currEqu.insert(0, stack.pop());
        currEqu.insert(currEqu.length() - 1, stack.pop());
        // System.out.println(currEqu);
        stack.push(currEqu);
      }
    }
    return (stack.pop().toString());
  }
}
