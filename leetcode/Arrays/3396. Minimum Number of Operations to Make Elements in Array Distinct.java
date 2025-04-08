class Solution {
    public int minimumOperations(int[] nums) {
        HashMap<Integer, Boolean> hash = new HashMap<>();
        int len = nums.length, breakIndex = 0;
        for(int index = len - 1; index >= 0 ; index--){
            if(hash.get(nums[index]) != null){
                breakIndex = index + 1;
                break;
            }
            hash.put(nums[index], true);
        }
        return (int) Math.ceil((breakIndex ) / 3.0);
    }
}