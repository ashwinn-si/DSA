class MyQueue {
  private Stack<Integer> inStack;
  private Stack<Integer> outStack;

  public MyQueue() {
    inStack = new Stack<>();
    outStack = new Stack<>();
  }

  public void push(int x) {
    inStack.push(x);
  }

  public int pop() {
    shiftStack();
    return outStack.pop();
  }

  public int peek() {
    shiftStack();
    return outStack.peek();
  }

  public boolean empty() {
    return inStack.isEmpty() && outStack.isEmpty();
  }

  private void shiftStack() {
    if (outStack.isEmpty()) {
      while (!inStack.isEmpty()) {
        outStack.push(inStack.pop());
      }
    }
  }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */