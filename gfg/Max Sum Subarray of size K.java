class Solution {
    public int maximumSumSubarray(int[] nums, int k) {
        int res = 0;
        int sum=0;

        for(int i=0; i<k;i++){
            sum += nums[i];
        }

        res = sum;

        for(int i=k; i<nums.length; i++){
            sum += nums[i];
            sum -= nums[i-k];
            res = Math.max(sum, res);
        }

        return res;
    }
}