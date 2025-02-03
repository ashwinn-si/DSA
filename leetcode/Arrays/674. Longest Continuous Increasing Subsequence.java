class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int res = 1, N = nums.length, left = 0, right = 1;
        while(right < N){
            if(nums[right-1] >= nums[right]) left = right;
            else res = Math.max(res , right - left + 1);
            right++;
        }
        return res;
    }
}

/*
 class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int res = 1, N = nums.length, counter = 0, right = 1;
        while(right < N){
            if(nums[right-1] >= nums[right]) counter = 1;
            else{
                counter++;
                res = Math.max(res , counter);
            }
            right++;
        }
        return res;
    }
}
 */