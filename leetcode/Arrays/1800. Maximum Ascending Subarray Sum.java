//kadanes algorithm
class Solution {
    public int maxAscendingSum(int[] nums) {
        int res = 0, N = nums.length, currSum = nums[0];
        for(int i = 1; i < N ; i++){
            if(nums[i] <= nums[i-1]){
                res = Math.max(res , currSum);
                currSum = 0;
            }
            currSum += nums[i];
        }
        res  = Math.max(res , currSum);
        return res;
    }
}