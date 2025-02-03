class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int incCount = 0 , decCount = 0 , N = nums.length,res = 0;
        for(int i = 0 ; i < N-1 ; i++){
            if(nums[i] < nums[i+1]){
                decCount++;
                incCount = 0;
            }else if(nums[i] > nums[i+1]){
                incCount++;
                decCount = 0;
            }else{
                incCount = 0;
                decCount = 0;
            }
            res = Math.max(Math.max(incCount , decCount),res);
        }
        return res+1;
        
    }
}