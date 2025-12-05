class Solution {
  int mainOrder(Stack<Integer> stack, int num) {
    while (!stack.isEmpty() && stack.peek() <= num) {
      stack.pop();
    }
    return stack.isEmpty() ? -1 : stack.peek();
  }

  public int[] nextGreaterElements(int[] nums) {
    int N = nums.length;
    Stack<Integer> stack = new Stack<>();
    for (int index = N - 1; index >= 0; index--) {
      mainOrder(stack, nums[index]);
      stack.push(nums[index]);
    }
    for (int index = N - 1; index >= 0; index--) {
      int num = nums[index];
      nums[index] = mainOrder(stack, num);
      stack.push(num);
    }
    return nums;
  }
}