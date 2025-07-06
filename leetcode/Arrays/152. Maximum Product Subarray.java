class Solution {
  public int maxProduct(int[] nums) {
    int product = 1;
    int result = nums[0];
    for (int index = 0; index < nums.length; index++) {
      product *= nums[index];
      result = Math.max(result, product);
      if (product == 0) {
        product = 1;
      }
    }
    product = 1;
    for (int index = nums.length - 1; index >= 0; index--) {
      product *= nums[index];
      result = Math.max(result, product);
      if (product == 0) {
        product = 1;
      }
    }
    return result;
  }
}