class Solution {
    public boolean isAcronym(List<String> words, String s) {
        int len = words.size();
        if(len != s.length()){
            return false;
        }
        for(int i = 0 ; i < len ; i++){
            if(words.get(i).charAt(0) != s.charAt(i)){
                return false;
            }
        }
        return true;
    }
}