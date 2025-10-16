class Solution {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode result = new ListNode(-1);
    ListNode returnNode = result;
    while (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        result.next = list1;
        list1 = list1.next;
      } else {
        result.next = list2;
        list2 = list2.next;
      }
      result = result.next;
    }
    while (list1 != null) {
      result.next = list1;
      list1 = list1.next;
      result = result.next;
    }
    while (list2 != null) {
      result.next = list2;
      list2 = list2.next;
      result = result.next;
    }
    return returnNode.next;
  }
}