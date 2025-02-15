class Solution {
    private String helper(String original, String part, int N, int M){
        for(int i = 0 ; i <= N-M ; i++){
            if(original.substring(i,i+M).equals( part)){
                return helper(original.substring(0,i)+original.substring(i+M,N),part,N-M,M);
            }
        }
        return original;
    }
    public String removeOccurrences(String s, String part) {
        return helper(s, part, s.length(), part.length());
    }
}