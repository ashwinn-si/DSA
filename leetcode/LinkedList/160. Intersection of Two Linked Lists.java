public class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null)
      return null;
    boolean aFlag = false;
    boolean bFlag = false;
    ListNode tempA = headA;
    ListNode tempB = headB;
    while (true) {
      if (tempA == tempB) {
        return tempA;
      }
      tempA = tempA.next;
      tempB = tempB.next;
      if (tempA == null) {
        if (!aFlag) {
          tempA = headB;
          aFlag = true;
        } else {
          return null;
        }
      }
      if (tempB == null) {
        if (!bFlag) {
          tempB = headA;
          bFlag = true;
        } else {
          return null;
        }
      }
    }
  }
}