public class Solution {
  public boolean hasCycle(ListNode head) {
    ListNode slow = head;
    if (head == null) {
      return false;
    }
    ListNode fast = head.next;
    if (fast == null) {
      return false;
    }
    fast = fast.next;
    while (fast != null && fast.next != null) {
      if (fast == slow) {
        return true;
      }
      slow = slow.next;
      fast = fast.next.next;
    }
    return false;
  }
}