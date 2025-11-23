class Solution {
  public int[] findMissingRepeatingNumbers(int[] nums) {
    int repeating = nums[0];
    int currSum = nums[0];
    HashMap<Integer, Integer> hash = new HashMap<>();
    for (int index = 1; index < nums.length; index++) {
      currSum += nums[index];
      if (hash.get(nums[index]) != null) {
        repeating = nums[index];
      }
      hash.put(nums[index], 1);
    }
    int requiredSum = (nums.length * (nums.length + 1)) / 2;
    currSum -= repeating;
    return new int[] { repeating, requiredSum - currSum };
  }
}