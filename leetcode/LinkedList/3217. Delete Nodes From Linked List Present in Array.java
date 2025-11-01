class Solution {
  public ListNode modifiedList(int[] nums, ListNode head) {
    ListNode result = new ListNode();
    ListNode curr = result;
    HashMap<Integer, Boolean> hash = new HashMap<>();
    for (int num : nums) {
      hash.put(num, true);
    }
    while (head != null) {
      if (hash.get(head.val) == null) {
        curr.next = new ListNode(head.val);
        curr = curr.next;
      }
      head = head.next;
    }
    return result.next;
  }
}