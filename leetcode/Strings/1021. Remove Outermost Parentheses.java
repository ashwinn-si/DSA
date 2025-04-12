class Solution {
    public String removeOuterParentheses(String s) {
        int openCount = 0;
        StringBuffer result = new StringBuffer();
        int len = s.length();
        for(int i = 0 ; i < len ; i++){
            if(s.charAt(i) == '('){
                openCount++;
            }
            if(openCount > 1){
                result.append(s.charAt(i));
            }
            if(s.charAt(i) == ')'){
                openCount--;
            }
            
        }
        return result.toString();
    }
}