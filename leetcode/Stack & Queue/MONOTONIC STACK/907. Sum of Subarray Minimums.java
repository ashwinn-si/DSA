class Solution {
  public int sumSubarrayMins(int[] nums) {
    int N = nums.length;
    int MOD = 1_000_000_007;
    int prev[] = new int[N];
    int next[] = new int[N];

    Stack<Integer> stack = new Stack<>();
    for (int index = N - 1; index >= 0; index--) {
      int num = nums[index];
      while (!stack.isEmpty() && nums[stack.peek()] > num) {
        stack.pop();
      }
      next[index] = stack.isEmpty() ? N : stack.peek();
      stack.push(index);
    }
    stack.clear();
    for (int index = 0; index < N; index++) {
      int num = nums[index];
      while (!stack.isEmpty() && nums[stack.peek()] >= num) {
        stack.pop();
      }
      prev[index] = stack.isEmpty() ? -1 : stack.peek();
      stack.push(index);
    }

    System.out.println(Arrays.toString(next));
    System.out.println(Arrays.toString(prev));
    long total = 0;
    for (int index = 0; index < N; index++) {
      long leftCount = index - prev[index];
      long rightCount = next[index] - index;
      total = (total + (long) nums[index] * leftCount * rightCount) % MOD;
    }
    return (int) total;
  }
}