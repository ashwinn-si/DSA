class Solution {
    public String reverseWords(String s) {
        String[] words = s.strip().split("\\s+");
        int len = words.length;
        StringBuffer str = new StringBuffer();
        for(int i = len - 1; i >= 0; i--){
            str.append(words[i].strip());
            if(i != 0){
                str.append(" ");
            }
        }
        return str.toString();
    }
}