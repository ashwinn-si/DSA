class Solution {
  int maintainOrder(Stack<Integer> stack, int num) {
    while (!stack.isEmpty() && stack.peek() < num) {
      stack.pop();
    }
    return stack.isEmpty() ? num : stack.peek();
  }

  public int trap(int[] nums) {
    int N = nums.length;
    int rightMax[] = new int[N];
    int leftMax[] = new int[N];
    Stack<Integer> stack = new Stack<>();
    for (int index = N - 1; index >= 0; index--) {
      rightMax[index] = maintainOrder(stack, nums[index]);
      if (stack.isEmpty() || stack.peek() < nums[index])
        stack.push(nums[index]);
    }
    while (!stack.isEmpty()) {
      stack.pop();
    }
    for (int index = 0; index < N; index++) {
      leftMax[index] = maintainOrder(stack, nums[index]);
      if (stack.isEmpty() || stack.peek() < nums[index])
        stack.push(nums[index]);
    }

    int total = 0;
    for (int index = 0; index < N; index++)
      total += Math.abs(nums[index] - Math.min(leftMax[index], rightMax[index]));
    return total;
  }
}