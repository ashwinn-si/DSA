public class Solution {
    public static int lowerBound(int []nums, int n, int x) {
       int st = 0, end = nums.length - 1, result = end + 1;
       while(st <= end){
            int mid = (st + end) / 2;
            if(nums[mid] >= x){
                result = mid;
                end = mid - 1;
            }else{
                st = mid + 1;
            }
       }
       return result;
    }
}