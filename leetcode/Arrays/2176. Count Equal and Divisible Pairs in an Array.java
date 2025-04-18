class Solution {
    public int countPairs(int[] nums, int k) {
        int count = 0, N = nums.length;
        for(int i = 0 ; i < N ; i++){
            for(int j = i + 1 ; j < N ; j++){
                if((i * j) % k == 0 && nums[i] == nums[j]){
                    count++;
                }
            }
        }
        return count;   
    }
}