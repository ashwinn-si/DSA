class Solution {
  long helper(int[] nums, int K, int N) {
    long sum = 0L;
    HashMap<Integer, Integer> hash = new HashMap<>();
    int leftPointer = 0;
    for (int rightPointer = 0; rightPointer < N; rightPointer++) {
      hash.put(nums[rightPointer], hash.getOrDefault(nums[rightPointer], 0) + 1);
      while (hash.size() > K) {
        if (hash.get(nums[leftPointer]) == 1) {
          hash.remove(nums[leftPointer]);
        } else {
          hash.put(nums[leftPointer], hash.get(nums[leftPointer]) - 1);
        }
        leftPointer++;
      }
      sum += rightPointer - leftPointer + 1;
    }
    return sum;
  }

  public int subarraysWithKDistinct(int[] nums, int k) {
    return (int) (helper(nums, k, nums.length) - helper(nums, k - 1, nums.length));
  }
}