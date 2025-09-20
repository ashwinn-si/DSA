class Solution {
  int maintainOrder(Stack<Integer> stack, int num) {
    while (!stack.isEmpty() && num > stack.peek()) {
      stack.pop();
    }
    return stack.isEmpty() ? -1 : stack.peek();
  }

  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    int N1 = nums1.length;
    int N2 = nums2.length;
    Stack<Integer> stack = new Stack<>();
    HashMap<Integer, Integer> hash = new HashMap<>();
    for (int index = N2 - 1; index >= 0; index--) {
      hash.put(nums2[index], maintainOrder(stack, nums2[index]));
      stack.push(nums2[index]);
    }

    for (int index = 0; index < N1; index++) {
      nums1[index] = hash.get(nums1[index]);
    }

    return nums1;
  }
}