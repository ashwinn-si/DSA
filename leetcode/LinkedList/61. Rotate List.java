/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  int findLength(ListNode node) {
    int count = 0;
    while (node != null) {
      count++;
      node = node.next;
    }
    return count;
  }

  ListNode getTargetNode(ListNode node, int index) {
    while (index > 0) {
      node = node.next;
      index--;
    }
    return node;
  }

  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || k == 0) {
      return head;
    }
    int n = findLength(head);
    k %= n;
    if (k == 0 || n == 1) {
      return head;
    }
    int targetIndex = n - k;
    ListNode newLastNode = getTargetNode(head, targetIndex - 1);
    ListNode firstNode = getTargetNode(head, targetIndex);
    ListNode lastNode = getTargetNode(head, n - 1);
    newLastNode.next = null;
    lastNode.next = head;
    return firstNode;
  }
}