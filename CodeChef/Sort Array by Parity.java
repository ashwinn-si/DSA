import java.util.*;

public class Main {
    
    public static void sortArrayByParity(int[] nums) {
        // Write your code here
        int N = nums.length;
        int odd[] = new int[N];
        int even[] = new int[N];
        int p1 = 0;
        int p2 = 0;
        for(int i : nums){
            if(i % 2 == 1){
                odd[p1] = i;
                p1++;
            }else{
                even[p2] = i;
                p2++;
            }
        }
        p1--;
        p2--;
        for(int i = 0 ; i < N ; i++){
            if(i <= p1){
                nums[i] = odd[i];   
            }else{
                nums[i] = even[i-p1-1];
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
        }

        sortArrayByParity(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}