class Solution {
    void reverse(int st , int end , int[] nums){
        while(st < end){
            int temp = nums[st];
            nums[st] = nums[end];
            nums[end] = temp;
            st++;
            end--;
        }
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int breakpoint = -1;
        //finding the brekpoint
        for(int i = n-2 ; i >= 0 ; i--){
            if(nums[i] < nums[i+1]){
                breakpoint = i;
                break;
            }
        } 
        //base case
        if(breakpoint == -1){
            reverse(0 , n-1 , nums);
            return ;
        }
        //swapping with the largest term
        for(int i = n-1 ; i >= 0 ; i--){
            if(nums[i] > nums[breakpoint]){
                int temp = nums[i];
                nums[i] = nums[breakpoint];
                nums[breakpoint] = temp;
                break;
            }
        }
        //reversing
        reverse(breakpoint+1 , n-1 , nums);
        return ;
    }
}