public class Solution {
  private ListNode detectHead(ListNode meetingPoint, ListNode head) {
    while (meetingPoint != head) {
      meetingPoint = meetingPoint.next;
      head = head.next;
    }
    return meetingPoint;
  }

  public ListNode detectCycle(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }

    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      if (slow == fast) {
        return detectHead(slow, head);
      }
    }

    return null;
  }
}
