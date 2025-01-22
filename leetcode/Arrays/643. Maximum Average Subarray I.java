class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int N = nums.length;
        double sum = 0;
        double res = 0;
        for(int i = 0 ; i < k ; i++){
            sum += nums[i];
        }
        res = sum / k;
        for(int i = k ; i  < N ; i++){
            sum -= nums[i-k];
            sum += nums[i];
            res = Math.max(res , sum / k);
        }
        return res;
    }
}