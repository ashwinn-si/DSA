class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minLen = Integer.MAX_VALUE;
        int len = strs.length;
        for(int i = 0; i < len ; i++){
            minLen = Math.min(minLen, strs[i].length());
        }   
        for(int pointer = 0 ; pointer < minLen ; pointer++){
            for(int strPointer = 0; strPointer < len - 1 ; strPointer++){
                if(strs[strPointer].charAt(pointer) != strs[strPointer+1].charAt(pointer)){
                    return strs[strPointer].substring(0, pointer);
                }
            }
        }
        return strs[0].substring(0, minLen);
    }
}