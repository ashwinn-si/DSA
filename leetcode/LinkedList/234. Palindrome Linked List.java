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
  public boolean isPalindrome(ListNode head) {
    // finding the middle using tortoise and the rabbit
    if (head == null || head.next == null) {
      return true;
    }
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    // now slow is the head of the linked list
    ListNode prevNode = null;
    while (slow != null) {
      ListNode nextNode = slow.next;
      slow.next = prevNode;
      prevNode = slow;
      slow = nextNode;
    }
    slow = prevNode;
    while (slow != null) {
      if (head.val != slow.val) {
        return false;
      }
      head = head.next;
      slow = slow.next;
    }
    return true;

  }
}