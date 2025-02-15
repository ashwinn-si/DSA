class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> hash = new HashMap<>();
        int count = 0 , maxLen = 0, N = nums.length;
        hash.put(0 , -1);
        for(int i = 0 ; i < N ; i++){
            if(nums[i] == 0) count--;
            else count++;
            if(hash.get(count) != null){
                maxLen = Math.max(maxLen, i -hash.get(count));
            }else{
                hash.put(count , i);
            }
        }
        return maxLen;
    }
}