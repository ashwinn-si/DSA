class Solution {
    public int jump(int[] nums) {
        int N = nums.length;
        int dp[] = new int[N];
        for(int index = N - 2; index >= 0; index--){
            int maxReachIndex = Math.min(N - 1, nums[index] + index);
            int result = Integer.MAX_VALUE;
            for(int currIndex = index + 1; currIndex <= maxReachIndex; currIndex++){
                if(dp[currIndex] == Integer.MAX_VALUE) continue;
                result = Math.min(1 + dp[currIndex], result);
            } 
            dp[index] = result == Integer.MAX_VALUE ? Integer.MAX_VALUE : result;
        }
        return dp[0];
    }
}