import java.util.*;

public class Main {
  static void insertAtLast(Stack<Integer> stack, int currElement) {
    if (stack.isEmpty()) {
      stack.push(currElement);
      return;
    }
    int top = stack.pop();
    insertAtLast(stack, currElement);
    stack.push(top);
  }

  static void reverse(Stack<Integer> stack) {
    if (stack.isEmpty()) {
      return;
    }
    int currElement = stack.pop();
    reverse(stack);
    insertAtLast(stack, currElement);
  }

  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.push(10);
    stack.push(20);
    stack.push(30);
    System.out.println(stack);
    reverse(stack);
    System.out.println(stack);
  }
}