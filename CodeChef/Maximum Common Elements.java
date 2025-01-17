import java.util.*;

class Codechef
{
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0; i < N; i++){
            int size = sc.nextInt();
            int arr1[] = new int[size];
            int arr2[] = new int[size];
            
            for(int j = 0; j < size; j++){
                arr1[j] = sc.nextInt();
            }
            
            for(int j = 0; j < size; j++){
                arr2[j] = sc.nextInt();
            }
            
            // Sort arrays
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            
            int pointer1 = 0;
            int pointer2 = 0;
            int count = 0;
            while(pointer1 < size && pointer2 < size){
                if(arr1[pointer1] == arr2[pointer2]){
                    count++;
                    pointer1++;
                    pointer2++;
                }
                else if(arr1[pointer1] < arr2[pointer2]){
                    pointer1++;
                }else{
                    pointer2++;
                }
            }
            System.out.println(count);
        }
    }
}
