class Solution {
    public int[] runningSum(int[] nums) {
        int currSum = 0;
        for(int i = 0 ; i < nums.length ; i++){
            currSum += nums[i];
            nums[i] = currSum;
        }
        return nums;
    }
}