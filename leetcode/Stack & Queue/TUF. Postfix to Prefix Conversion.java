class Solution {
  public String postToPre(String str) {
    // Your code goes here
    Stack<StringBuffer> stack = new Stack();
    for (int index = 0; index < str.length(); index++) {
      char ch = str.charAt(index);
      if (Character.isLetterOrDigit(ch)) {
        stack.push(new StringBuffer(String.valueOf(ch)));
      } else {
        StringBuffer currEqu = new StringBuffer();
        currEqu.append(ch);
        currEqu.insert(1, stack.pop());
        currEqu.insert(1, stack.pop());
        // System.out.println(currEqu);
        stack.push(currEqu);
      }
    }
    return (stack.pop().toString());
  }
}
