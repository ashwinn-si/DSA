class Solution {
    public String findDifferentBinaryString(String[] nums) {
        HashMap<Integer, Boolean> hash = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for(String str : nums){
            hash.put(Integer.parseInt(str, 2), true);
            max = Math.max(Integer.parseInt(str,2), max);
        }
        int reqLen = nums.length;
        for(int i = 0 ; i <= max+1 ; i++){
            if(hash.get(i) == null){
                String binary = Integer.toBinaryString(i);
                return "0".repeat(reqLen - binary.length()) + binary;
            }
        }
        return "";
    }
}