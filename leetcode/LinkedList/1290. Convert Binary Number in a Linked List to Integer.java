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
  public int getDecimalValue(ListNode head) {
    int result = 0;
    int pow = 0;
    ListNode prevNode = null;
    while (head != null) {
      ListNode nextNode = head.next;
      head.next = prevNode;
      prevNode = head;
      head = nextNode;
    }
    head = prevNode;
    while (head != null) {
      result += ((int) (Math.pow(2, pow++)) * head.val);
      head = head.next;
    }
    return result;
  }
}