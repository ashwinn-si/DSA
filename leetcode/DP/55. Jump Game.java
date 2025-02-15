class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0, N = nums.length;
        for(int index = 0 ; index  < N - 1 ; index++){
            if(index <= maxReach){
                maxReach  = Math.max( maxReach , nums[index] + index );
            }else{
                return false;
            }
            
        }
        return maxReach >= N - 1;
    }
}