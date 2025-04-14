public class Solution {
    public static int upperBound(int []nums, int x, int n){
        // Write your code here.
        int st = 0, end = n -1, result = n;
        while(st <= end){
            int mid = (st + end) / 2;
            if(nums[mid] > x){
                result = mid;
                end = mid - 1;
            }else{
                st = mid + 1;
            }
        }
        return result;
    }
}
