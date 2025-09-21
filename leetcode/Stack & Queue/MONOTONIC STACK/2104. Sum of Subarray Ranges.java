import java.util.Stack;

class Solution {
  public long subArrayRanges(int[] nums) {
    int n = nums.length;
    int[] prevLess = new int[n], nextLess = new int[n];
    int[] prevGreater = new int[n], nextGreater = new int[n];
    Stack<Integer> st = new Stack<>();

    // prevLess: previous index with value < nums[i], else -1
    for (int i = 0; i < n; i++) {
      while (!st.isEmpty() && nums[st.peek()] >= nums[i])
        st.pop();
      prevLess[i] = st.isEmpty() ? -1 : st.peek();
      st.push(i);
    }

    // nextLess: next index with value <= nums[i], else n
    st.clear();
    for (int i = n - 1; i >= 0; i--) {
      while (!st.isEmpty() && nums[st.peek()] > nums[i])
        st.pop();
      nextLess[i] = st.isEmpty() ? n : st.peek();
      st.push(i);
    }

    // prevGreater: previous index with value > nums[i], else -1
    st.clear();
    for (int i = 0; i < n; i++) {
      while (!st.isEmpty() && nums[st.peek()] <= nums[i])
        st.pop();
      prevGreater[i] = st.isEmpty() ? -1 : st.peek();
      st.push(i);
    }

    // nextGreater: next index with value >= nums[i], else n
    st.clear();
    for (int i = n - 1; i >= 0; i--) {
      while (!st.isEmpty() && nums[st.peek()] < nums[i])
        st.pop();
      nextGreater[i] = st.isEmpty() ? n : st.peek();
      st.push(i);
    }

    long result = 0L;
    for (int i = 0; i < n; i++) {
      long leftMin = i - prevLess[i];
      long rightMin = nextLess[i] - i;
      long leftMax = i - prevGreater[i];
      long rightMax = nextGreater[i] - i;
      long val = nums[i];
      result += val * (leftMax * rightMax - leftMin * rightMin);
    }
    return result;
  }
}
