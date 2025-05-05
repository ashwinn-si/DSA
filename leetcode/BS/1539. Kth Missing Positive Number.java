/*Brute Force Solution*/
class Solution {
    public int findKthPositive(int[] nums, int k) {
        if(k < nums[0]){
            return k;
        }
        for(int num : nums){
            if(num <= k){
                k++;
                continue;
            }
            return k;
        }
        return k;
    }
}