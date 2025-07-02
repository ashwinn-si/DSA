class Solution {
  public int subarraySum(int[] nums, int K) {
    int resCount = 0;
    HashMap<Integer, Integer> hash = new HashMap<>();
    int sum = 0;
    int N = nums.length;
    for (int rightPointer = 0; rightPointer < N; rightPointer++) {
      sum += nums[rightPointer];
      if (sum == K) {
        resCount++;
      }
      int needSum = sum - K;
      if (hash.get(needSum) != null) {
        resCount += hash.get(needSum);
      }
      hash.put(sum, hash.getOrDefault(sum, 0) + 1);
    }
    return resCount;
  }
}