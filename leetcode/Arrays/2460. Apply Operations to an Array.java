class Solution {
    public int[] applyOperations(int[] nums) {
        int len = nums.length;
        for(int i = 0 ; i < len-1 ; i++){
            if(nums[i] == nums[i+1]){
                nums[i] *= 2;
                nums[i+1] = 0;
            }
        }
        int pointer1 = 0;
        for(int pointer2 = 0 ; pointer2 < len ; pointer2++){
            if(nums[pointer2] != 0){
                int temp = nums[pointer1];
                nums[pointer1] = nums[pointer2];
                nums[pointer2] = temp;
                pointer1++;
            }
        }
        return nums;
    }
}