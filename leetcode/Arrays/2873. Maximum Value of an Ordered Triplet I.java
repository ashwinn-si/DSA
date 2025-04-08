class Solution {
    public long maximumTripletValue(int[] nums) {
        long result = 0;
        long runningMaxValue = 0;
        long runningDiff = 0;
        for(int n : nums){
            result = Math.max(result, runningDiff * n);
            runningDiff = Math.max(runningDiff, (runningMaxValue - n));
            runningMaxValue = Math.max(runningMaxValue, n);
        }
        return result;
    }
}