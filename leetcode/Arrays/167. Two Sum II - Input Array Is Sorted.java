class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int st = 0;
        int end = numbers.length -1 ;
        while(numbers[st] + numbers[end] != target){
            if(numbers[st]+ numbers[end] > target){
                    end--;
            }else{
                st++;
            }
        }
        return new int[]{st+1,end+1};
    }
}