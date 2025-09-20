class Solution {
  int maintainOrder(Stack<Integer> stack, int num) {
    while (!stack.isEmpty() && stack.peek() >= num) {
      stack.pop();
    }
    return stack.isEmpty() ? -1 : stack.peek();
  }

  public int[] nextSmallerElements(int[] nums) {
    // Your code goes here
    int N = nums.length;
    Stack<Integer> stack = new Stack<>();
    for (int index = N - 1; index >= 0; index--) {
      int num = nums[index];
      nums[index] = maintainOrder(stack, nums[index]);
      stack.push(num);
    }
    return nums;
  }
}