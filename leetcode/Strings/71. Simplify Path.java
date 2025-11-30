class Solution {
  public String simplifyPath(String path) {
    Stack<StringBuffer> stack = new Stack<>();
    StringBuffer str = new StringBuffer();
    for (int index = 0; index < path.length(); index++) {
      char ch = path.charAt(index);
      if (ch == '/') {
        if (str.length() != 0) {
          if (str.toString().equals("..")) {
            if (!stack.isEmpty()) {
              stack.pop();
            }
          } else {
            if (!str.toString().equals(".")) {
              stack.push(str);
            }
          }
        }
        str = new StringBuffer();
      } else {
        str.append(ch);
      }
    }
    if (str.length() > 0) {
      if (!str.toString().equals(".") && !str.toString().equals("..")) {
        stack.push(str);
      }
      if (str.toString().equals("..")) {
        if (!stack.isEmpty()) {
          stack.pop();
        }
      }
    }
    str = new StringBuffer();
    while (!stack.isEmpty()) {
      str.insert(0, stack.pop() + "/");
    }
    if (str.length() > 0) {
      str.deleteCharAt(str.length() - 1);
    }
    str.insert(0, "/");
    return str.toString();
  }
}