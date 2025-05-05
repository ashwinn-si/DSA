class Solution {
    public boolean isIsomorphic(String s, String t) {
        int slen = s.length(), tlen = t.length();
        if(s.equals(t)){
            return true;
        }
        if(slen != tlen){
            return false;
        }
        HashMap<Character, Character> sTot = new HashMap<>();
        HashMap<Character, Character> tTos = new HashMap<>();
        for(int i = 0 ; i < slen ; i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(sTot.get(c1) != null && tTos.get(c2) != null && (sTot.get(c1) != c2 || tTos.get(c2) != c1)){
                return false;
            }
            if(sTot.get(c1) == null && tTos.get(c2) == null){
                sTot.put(c1, c2);
                tTos.put(c2, c1);
            }else if(sTot.get(c1) == null || tTos.get(c2) == null){
                return false;
            }
        }
        return true;
        
    }
}