class Solution {
    public int triangularSum(int[] nums) {
        int count = 0 ;
        int n = nums.length;
        while(count < Math.max(n-1,0)){
            for(int i = 0 ; i < n - 1 - count;i++){
                nums[i] = (nums[i] + nums[i+1]) % 10;
            }
            count++;            
        }
        return nums[0];
    }
}