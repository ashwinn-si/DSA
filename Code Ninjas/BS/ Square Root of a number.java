import java.util.* ;
import java.io.*; 

public class Solution {

	public static int sqrtN(long N) {
		 long st = 1, end = N;
		 int result = 1;
		 while(st <= end){
			 int mid = (int) ((st + end) / 2);
			 if(mid * mid <= N){
				result = (mid);
				st = mid + 1;
			 }
			 else{
			 	end = mid - 1;
			}
		 }
		 return result;
		
	}
}
