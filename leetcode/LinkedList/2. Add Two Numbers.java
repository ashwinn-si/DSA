class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode resultNode = new ListNode();
    ListNode dummy = resultNode;
    int carry = 0;
    while (l1 != null || l2 != null || carry != 0) {
      int val1 = l1 != null ? l1.val : 0;
      int val2 = l2 != null ? l2.val : 0;

      int sum = val1 + val2 + carry;
      carry = sum / 10;

      resultNode.next = new ListNode(sum % 10);
      resultNode = resultNode.next;

      if (l1 != null)
        l1 = l1.next;
      if (l2 != null)
        l2 = l2.next;
    }
    return dummy.next;
  }
}