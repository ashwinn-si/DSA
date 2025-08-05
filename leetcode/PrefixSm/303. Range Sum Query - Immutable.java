class NumArray {
  int[] nums;

  public NumArray(int[] nums) {
    int N = nums.length;
    this.nums = new int[N];
    this.nums[0] = nums[0];
    for (int i = 1; i < N; i++) {
      this.nums[i] = this.nums[i - 1] + nums[i];
    }
  }

  public int sumRange(int left, int right) {
    if (left == 0) {
      return this.nums[right];
    }
    return this.nums[right] - this.nums[left - 1];
  }
}
