class Solution {
  ListNode merge(ListNode h1, ListNode h2) {
    ListNode result = new ListNode(-1);
    ListNode cpy = result;
    while (h1 != null && h2 != null) {
      if (h1.val < h2.val) {
        result.next = h1;
        h1 = h1.next;
      } else {
        result.next = h2;
        h2 = h2.next;
      }
      result = result.next;
    }
    if (h1 != null) {
      result.next = h1;
    }
    if (h2 != null) {
      result.next = h2;
    }
    return cpy.next;
  }

  public ListNode mergeKLists(ListNode[] lists) {
    ListNode result = null;
    for (ListNode node : lists) {
      result = merge(result, node);
    }
    return result;
  }
}