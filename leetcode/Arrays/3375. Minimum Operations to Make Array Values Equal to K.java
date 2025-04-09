class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int len = nums.length;
        for(int index = 0 ; index < len ; index++){
            set.add(nums[index]);
        }
        int count = 0;
        for(int num : set){
            if(num > k){
                count++;
            }else if(num < k){
                return -1;
            }
        }
        return count;
    }
}