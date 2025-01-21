class Solution {
    public int maxAdjacentDistance(int[] nums) {
        for(int i = 0 ,N = nums.length, res = -1 ; i < N ; i++){
            if(i == N-1){
                res = Math.max(res,Math.abs(nums[0]-nums[i]));
                return res;
            }
            res = Math.max(res,Math.abs(nums[i+1]-nums[i]));
        }
        return 0;
    }
}