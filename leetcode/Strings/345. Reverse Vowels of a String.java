class Solution {
    public boolean helper(char ch){
        ch = Character.toLowerCase(ch);
        if(ch == 'a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
            return true;
        }
        return false;
    }
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int pointer1 = 0;
        int pointer2 = arr.length - 1;
        while(pointer1 < pointer2){
            //finding the first vowel in forward
            if(helper(arr[pointer1])){
                //finding the second vowel in backwards
                while(!helper(arr[pointer2])){
                    pointer2--;
                }
                char temp = arr[pointer1];
                arr[pointer1] = arr[pointer2];
                arr[pointer2] = temp;
                pointer2--;
            }
            pointer1++;
        }
        return new String(arr);
    }
}