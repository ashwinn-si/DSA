import java.util.* ;
import java.io.*; 

public class Solution {
    public static int[] getFloorAndCeil(int[] nums, int n, int x) {
      // Wriute your code here.
      int floor = -1, ceil = -1;
      int st = 0, end = n - 1;
      //floor -> it is number <= x
      while(st <= end){
        int mid = (st + end) / 2;
        if(nums[mid] == x){
          return new int[]{x, x};
        }else if(nums[mid] < x){
          floor = nums[mid];
          st = mid + 1;
        }else{
          end = mid - 1;
        }
      }
      st = 0;
      end = n - 1;
      //ceil -> it is number >= x
      while(st <= end){
        int mid = (st + end) / 2;
        if(nums[mid] > x){
          ceil = nums[mid];
          end = mid - 1;
        }else{
          st = mid + 1;
        }
      }
      return new int[]{floor, ceil};
    }
    
}