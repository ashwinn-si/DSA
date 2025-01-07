class Solution {
    public void helper(int p1 , int p2 , char[] arr){
        while(p1 < p2){
            char temp = arr[p1];
            arr[p1] = arr[p2];
            arr[p2] = temp;
            p1++;
            p2--;
        }
    }
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int pointer1 = 0;
        int pointer2 = 0;
        while(pointer2 < n){
            //finding the word
            if(arr[pointer2] == ' ' || pointer2 == n-1){
                helper(pointer1, pointer2 != n-1 ? pointer2-1 : pointer2, arr);
                pointer1 = pointer2+1;
            }
            pointer2++;
        }
        return new String(arr);
    }
}