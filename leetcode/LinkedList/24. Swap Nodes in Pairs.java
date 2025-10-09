class Solution {
  public ListNode swapPairs(ListNode head) {
    ListNode result = new ListNode(-1);
    ListNode cpy = result;
    while (head != null && head.next != null) {
      ListNode nextNode = head.next.next;
      result.next = head.next;
      result.next.next = head;
      result = result.next.next;
      result.next = null;
      head = nextNode;
    }
    if (head != null) {
      result.next = head;
      result.next.next = null;
    }
    return cpy.next;
  }
}