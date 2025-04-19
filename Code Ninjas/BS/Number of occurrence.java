public class Solution {
    public static int count(int nums[], int N, int target) {
        //Your code goes here
        int st = 0, end = N - 1, first = -1, last = -1;
        
        //finding the first one
        while(st <= end){
            int mid = ( st + end ) / 2;
            if(nums[mid] == target){
                first = mid;
                end = mid - 1;
            }else if(nums[mid] > target){
                end = mid - 1;
            }else{
                st = mid + 1;
            }
        }

        //finding the last one
        st = 0; end = N - 1;
        while(st <= end){
            int mid = ( st + end ) / 2;
            if(nums[mid] == target){
                last = mid;
                st = mid + 1;
            }else if(nums[mid] > target){
                end = mid - 1;
            }else{
                st = mid + 1;
            }
        }
        if(first == -1) return 0;
        return last - first + 1;
    }
}