class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = 0;
        int res = nums[0];
        int N = nums.length;
        for(int i = 0 ;i < N ; i++){
            currSum += nums[i];
            if(currSum > res){
                res = currSum;
            }
            if(currSum < 0){
                currSum = 0;
            }
        }
        return res;
    }
}