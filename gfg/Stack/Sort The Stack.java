//IMP SLOVE REVERSE A STACK AND TRY TO DO IT
class GfG {
  void helper2(Stack<Integer> stack, int currElement) {
    if (stack.isEmpty() || stack.peek() <= currElement) {
      stack.push(currElement);
      return;
    }
    int top = stack.pop();
    helper2(stack, currElement);
    stack.push(top);
  }

  void helper1(Stack<Integer> stack) {
    if (stack.isEmpty()) {
      return;
    }
    int currElement = stack.pop();
    helper1(stack);
    helper2(stack, currElement);
  }

  public Stack<Integer> sort(Stack<Integer> stack) {
    // add code here.
    helper1(stack);
    return stack;
  }
}