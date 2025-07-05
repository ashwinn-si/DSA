class Solution {
  // Function to find two elements in array
  ArrayList<Integer> findTwoElement(int nums[]) {
    // code here
    HashSet<Integer> hash = new HashSet<>();
    Integer missing = -1, repeating = -1;
    for (int num : nums) {
      if (hash.contains(num)) {
        repeating = num;
      }
      hash.add(num);
    }
    int size = nums.length;
    for (int i = 0; i < size; i++) {
      if (!hash.contains(i + 1)) {
        missing = i + 1;
        break;
      }
    }
    return new ArrayList<>(Arrays.asList(repeating, missing));
  }
}

/*
 * long sum = 0;
 * long sum2 = 0;
 * int n = nums.length;
 * 
 * for (int num : nums) {
 * sum += num;
 * sum2 += (long) num * num; // cast to long to avoid overflow
 * }
 * 
 * long expectedSum = (long) n * (n + 1) / 2;
 * long expectedSumSq = (long) n * (n + 1) * (2L * n + 1) / 6;
 * 
 * long diff = sum - expectedSum; // R - M
 * long sqDiff = sum2 - expectedSumSq; // R^2 - M^2 = (R - M)(R + M)
 * 
 * long sumRM = sqDiff / diff; // R + M
 * 
 * int repeating = (int) ((diff + sumRM) / 2);
 * int missing = (int) (repeating - diff);
 * 
 * return new ArrayList<>(Arrays.asList(repeating, missing));
 */