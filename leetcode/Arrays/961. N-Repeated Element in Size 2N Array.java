class Solution {
  public int repeatedNTimes(int[] nums) {
    HashMap<Integer, Integer> hash = new HashMap<>();
    for (int num : nums) {
      hash.put(num, hash.getOrDefault(num, 0) + 1);
    }
    for (int num : hash.keySet()) {
      if (hash.get(num) == nums.length / 2) {
        return num;
      }
    }
    return -1;
  }
}