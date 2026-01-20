class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    Deque<int[]> queue = new ArrayDeque<>();
    int result[] = new int[nums.length - k + 1];
    int resIndex = 0;
    for (int index = 0; index < nums.length; index++) {
      int num = nums[index];
      while (!queue.isEmpty() && queue.peekFirst()[1] <= index - k) {
        queue.pollFirst();
      }
      while (!queue.isEmpty() && queue.peekLast()[0] < num) {
        queue.pollLast();
      }
      queue.offerLast(new int[] { num, index });
      if (index >= k - 1) {
        result[resIndex++] = queue.peekFirst()[0];
      }
    }
    return result;
  }
}