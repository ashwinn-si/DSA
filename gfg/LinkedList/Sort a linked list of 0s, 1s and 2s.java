class Solution {
  static Node segregate(Node head) {
    Node zeroHead = new Node(-1);
    Node oneHead = new Node(-1);
    Node twoHead = new Node(-1);
    Node zero = zeroHead, one = oneHead, two = twoHead;

    while (head != null) {
      if (head.data == 0) {
        zero.next = head;
        zero = zero.next;
      } else if (head.data == 1) {
        one.next = head;
        one = one.next;
      } else {
        two.next = head;
        two = two.next;
      }
      head = head.next;
    }

    two.next = null;
    one.next = twoHead.next;
    zero.next = oneHead.next;

    return zeroHead.next;
  }
}
