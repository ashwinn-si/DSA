
class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        int largestElement = 0;
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = n-1 ; i >= 0 ; i--){
            if(arr[i] >= largestElement){
                res.add(arr[i]);
                largestElement = arr[i];
            }
        }
        Collections.reverse(res);
        return res;
    }
}