class LinkedListQueue {
  Node left;
  Node right;

  public LinkedListQueue() {
    left = null;
    right = null;
  }

  public void push(int x) {
    if (left == null && right == null) {
      left = new Node(x);
      right = left;
    } else {
      right.nextNode = new Node(x, right);
      right = right.nextNode;
    }
  }

  public int pop() {
    int value = left.value;
    left = left.nextNode;
    if (left == null) {
      right = null;
    }
    return value;
  }

  public int peek() {
    return left.value;
  }

  public boolean isEmpty() {
    return left == null || right == null;
  }
}

class Node {
  int value;
  Node prevNode;
  Node nextNode;

  Node(int value) {
    this.value = value;
    this.nextNode = null;
    this.prevNode = null;
  }

  Node(int value, Node prevNode) {
    this.value = value;
    this.prevNode = prevNode;
    this.nextNode = null;
  }
}