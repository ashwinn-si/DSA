class Solution {
    public int maxDepth(String s) {
        int noOpen = 0, result = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                noOpen++;
            }else if(ch == ')'){
                noOpen--;
            }
            result = Math.max(result, noOpen);
        }
        return result;
    }
}