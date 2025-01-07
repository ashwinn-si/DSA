package leetcode;
class Solution {
    public void moveZeroes(int[] nums) {
        int pointer1 = 0;
        int n = nums.length;
        for(int pointer2 = 0 ; pointer2 < n ; pointer2++){
            if(nums[pointer2] != 0){
                nums[pointer1] = nums[pointer2];
                if(pointer1 != pointer2){
                    nums[pointer2] = 0;
                }
                pointer1++;
            }
        }
    }
}
