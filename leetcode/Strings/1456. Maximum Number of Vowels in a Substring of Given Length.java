class Solution {
    boolean helper(char ch){
        if(ch == 'a' || ch=='e' || ch=='i' || ch=='o' || ch == 'u') return true;
        return false; 
    }
    public int maxVowels(String s, int k) {
        int N = s.length();
        int res = 0;
        int count = 0;
        for(int i = 0 ; i < k ; i++){
            if(helper(s.charAt(i))){
                count++;
            }
        }
        res = Math.max(count,res);
        for(int i = k ; i < N ; i++){
            if(helper(s.charAt(i))) count++;
            if(helper(s.charAt(i-k))) count--;
            res = Math.max(count , res);
        }
        return res;
    }
}