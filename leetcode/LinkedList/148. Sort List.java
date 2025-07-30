class Solution {
  ListNode findMid(ListNode head) {
    if (head == null)
      return null;
    if (head.next == null)
      return head;
    ListNode slow = head;
    ListNode fast = head.next.next;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  ListNode merge(ListNode left, ListNode right) {
    ListNode dummy = new ListNode(-1); // Dummy head
    ListNode tail = dummy;

    while (left != null && right != null) {
      if (left.val < right.val) {
        tail.next = left;
        left = left.next;
      } else {
        tail.next = right;
        right = right.next;
      }
      tail = tail.next;
    }

    if (left != null)
      tail.next = left;
    if (right != null)
      tail.next = right;

    return dummy.next;
  }

  ListNode mergeSort(ListNode head) {
    if (head == null || head.next == null)
      return head;
    // finding the mid point
    ListNode leftHead = head;
    ListNode midNode = findMid(head);
    ListNode rightHead = midNode.next;
    midNode.next = null;
    leftHead = mergeSort(leftHead);
    rightHead = mergeSort(rightHead);
    return merge(leftHead, rightHead);
  }

  public ListNode sortList(ListNode head) {
    return mergeSort(head);
  }
}