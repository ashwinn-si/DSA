class Solution {
  Node reverse(Node head) {
    if (head == null || head.next == null)
      return head;
    Node prev = null;
    while (head != null) {
      Node next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }

  public Node addOne(Node head) {
    // code here.
    head = reverse(head);

    Node temp = head;
    int carry = 1;

    while (temp != null) {
      int sum = temp.data + carry;
      temp.data = sum % 10;
      carry = sum / 10;
      if (carry == 0)
        break;
      if (temp.next == null && carry != 0) {
        temp.next = new Node(carry);
        break;
      }
      temp = temp.next;
    }
    return reverse(head);
  }
}