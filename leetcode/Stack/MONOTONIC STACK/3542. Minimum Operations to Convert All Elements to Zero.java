class Solution {
  public int minOperations(int[] nums) {
    // monotonic increasing stack
    Stack<Integer> stack = new Stack<>();
    int res = 0;
    for (int num : nums) {
      while (!stack.isEmpty() && stack.peek() > num) {
        stack.pop();
      }
      if (num == 0) {
        continue;
      }
      if (stack.isEmpty() || stack.peek() < num) {
        stack.push(num);
        res++;
      }
    }
    return res;
  }
}