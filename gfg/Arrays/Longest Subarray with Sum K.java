// User function Template for Java

class Solution {
  public int longestSubarray(int[] nums, int target) {
    // code here
    HashMap<Integer, Integer> hash = new HashMap<>();
    int N = nums.length;
    int currSum = 0;
    int result = 0;
    for (int i = 0; i < N; i++) {
      currSum += nums[i];
      if (currSum == target) {
        result = Math.max(result, i + 1);
      }
      int neededSum = currSum - target;
      if (hash.get(neededSum) != null) {
        result = Math.max(result, i - hash.get(neededSum));
      }
      if (hash.get(currSum) == null) {
        hash.put(currSum, i);
      }
    }
    return result;
  }
}
