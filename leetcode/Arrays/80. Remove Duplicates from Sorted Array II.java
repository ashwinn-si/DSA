class Solution {
    public int removeDuplicates(int[] nums) {
        int pointer1 = 1;
        int currNum = nums[0];
        int count = 1;
        for(int pointer2 = 1 ; pointer2 < nums.length ; pointer2++){
            if(currNum == nums[pointer2]){
                if(count < 2){
                    int temp = nums[pointer1];
                    nums[pointer1] = nums[pointer2];
                    nums[pointer2] = temp;
                    count++;
                    pointer1++;
                }
            }else{
                currNum = nums[pointer2];
                count  = 1;
                int temp = nums[pointer1];
                nums[pointer1] = nums[pointer2];
                nums[pointer2] = temp;
                pointer1++;
            }
        }
        return pointer1;
    }
}