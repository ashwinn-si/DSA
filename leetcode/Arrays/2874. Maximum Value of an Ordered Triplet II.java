class Solution {
    public long maximumTripletValue(int[] nums) {
        long runningDifference = 0;
        long runningMaxValue = 0;
        long result = 0;
        int len = nums.length;
        for(int i = 0 ; i < len ; i++){
            result = Math.max(result , runningDifference * nums[i]);
            runningDifference = Math.max(runningDifference,runningMaxValue - nums[i]);
            runningMaxValue = Math.max(runningMaxValue, nums[i]);
        }
        return result;
    }
}