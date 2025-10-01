class LRUCache {
  public int maxSize, currSize;
  HashMap<Integer, Node> hash = new HashMap<>();
  Node head, tail;

  public LRUCache(int capacity) {
    maxSize = capacity;
    currSize = 0;
    hash = new HashMap<>();
    head = new Node(-1, -1);
    tail = new Node(-1, -1);
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    if (hash.get(key) != null) {
      Node currNode = hash.get(key);
      deleteFromMiddle(currNode);
      insertAtHead(currNode);
      return currNode.value;
    } else {
      return -1;
    }
  }

  public void put(int key, int value) {
    if (hash.get(key) != null) {
      Node currNode = hash.get(key);
      currNode.value = value;
      deleteFromMiddle(currNode);
      insertAtHead(currNode);
    } else {
      if (currSize == maxSize) {
        Node deleteNode = tail.prev;
        deleteFromMiddle(deleteNode);
        hash.remove(deleteNode.key);
        currSize--;
      }
      Node newNode = new Node(key, value);
      hash.put(key, newNode);
      insertAtHead(newNode);
      currSize++;
    }
  }

  public void insertAtHead(Node newNode) {
    Node nextNode = head.next;
    head.next = newNode;
    newNode.prev = head;
    nextNode.prev = newNode;
    newNode.next = nextNode;
  }

  public void deleteFromMiddle(Node deleteNode) {
    Node nextNode = deleteNode.next;
    Node prevNode = deleteNode.prev;
    nextNode.prev = prevNode;
    prevNode.next = nextNode;
    deleteNode.next = null;
    deleteNode.prev = null;
  }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
class Node {
  int value;
  int key;
  Node prev, next;

  Node(int key, int value) {
    this.value = value;
    this.key = key;
  }
}