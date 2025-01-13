class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int currElement = 0;
        int len = nums.length;
        for(int i = 0 ; i < len ; i++){
            if(count == 0){
                currElement = nums[i];
                count = 1;
            }else if( nums[i] != currElement){
                count--;
            }else{
                count++;
            }
        }
        
        return currElement;
    }
}