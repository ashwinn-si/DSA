class Solution {
    public int minOperations(int[] nums, int k) {
        for(int i =0, N = nums.length, count = 0; i < N ; i++){
            if(nums[i] < k){
                count++;
            }
            if(i == N-1){
                return count;
            }
        }
        return -1;
    }
}