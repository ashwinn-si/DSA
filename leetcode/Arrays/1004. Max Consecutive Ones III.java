class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int result = 0;
        int flag = 0;
        int N = nums.length;
        for(int right = 0 ; right <  N ; right++){
            if(nums[right] == 0){
                flag++;
            }
            while(flag > k){
                if(nums[left] == 0){
                    flag--;
                }left++;
            }
            result = Math.max(result , right - left+1);
        }
        return result;
    }
}