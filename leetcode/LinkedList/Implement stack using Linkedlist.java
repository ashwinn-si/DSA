class LinkedListStack {
  Node head;
  Node currNode;

  public LinkedListStack() {
    head = null;
    currNode = null;
  }

  public void push(int x) {
    if (head == null) {
      head = new Node(x);
      currNode = head;
    } else {
      Node nextNode = new Node(x);
      currNode.next = nextNode;
      nextNode.prev = currNode;
      currNode = currNode.next;
    }
  }

  public int pop() {
    int value = currNode.value;
    currNode = currNode.prev;
    if (currNode == null) {
      head = null;
    }
    return value;
  }

  public int top() {
    return currNode.value;
  }

  public boolean isEmpty() {
    return head == null;
  }
}

class Node {
  int value;
  Node prev, next;

  Node(int value) {
    this.value = value;
    this.prev = null;
    this.next = null;
  }
}