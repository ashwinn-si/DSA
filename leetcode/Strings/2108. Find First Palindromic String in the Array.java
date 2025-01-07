class Solution {
    public boolean helper(String str){
        int pointer1= 0;
        int pointer2 = str.length()-1;
        while(pointer1 < pointer2){
            if(str.charAt(pointer1) != str.charAt(pointer2)){
                return false;
            }
            pointer1++;
            pointer2--;
        }
        return true;
    }
    public String firstPalindrome(String[] words) {
        for(String str : words){
            if(helper(str)){
                return str;
            }
        }
        return "";
    }

}