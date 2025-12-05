class Solution {
  public int largestRectangleArea(int[] nums) {
    int N = nums.length;
    int prevSmall[] = new int[N];
    int nextSmall[] = new int[N];
    Stack<Integer> stack = new Stack<>();
    for (int index = 0; index < N; index++) {
      int num = nums[index];
      while (!stack.isEmpty() && nums[stack.peek()] > num) {
        stack.pop();
      }
      prevSmall[index] = stack.isEmpty() ? -1 : stack.peek();
      stack.push(index);
    }
    stack.clear();
    for (int index = N - 1; index >= 0; index--) {
      int num = nums[index];
      while (!stack.isEmpty() && nums[stack.peek()] >= num) {
        stack.pop();
      }
      nextSmall[index] = stack.isEmpty() ? N : stack.peek();
      stack.push(index);
    }
    int result = 0;
    for (int index = 0; index < N; index++) {
      int left = index - prevSmall[index];
      int right = nextSmall[index] - index;
      result = Math.max(result, (left + right - 1) * nums[index]);
    }
    return result;
  }

  public int maximalRectangle(char[][] matrix) {
    int R = matrix.length;
    int C = matrix[0].length;
    int nums[] = new int[C];
    int result = 0;
    for (int row = 0; row < R; row++) {
      for (int col = 0; col < C; col++) {
        if (matrix[row][col] == '0') {
          nums[col] = 0;
        } else {
          nums[col] += 1;
        }
      }
      result = Math.max(result, largestRectangleArea(nums));
    }
    return result;
  }
}