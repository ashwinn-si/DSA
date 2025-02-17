//! try using memomization

class Solution {
    private HashSet<String> hash = new HashSet<>();
    public int dfs(String processed, String unProcessed){
        if(processed.length() > 0){
            hash.add(processed);
        }
        if(unProcessed.length() == 0){
            return 1;
        }
        int unProcessedLen = unProcessed.length();
        int count = 0;
        for (int i = 0 ; i < unProcessedLen ; i++){
            count += dfs(processed + unProcessed.charAt(i), unProcessed.substring(0,i)+unProcessed.substring(i+1, unProcessedLen));
        }
        return count;
    }
    public int numTilePossibilities(String tiles) {
        dfs("", tiles);
        return hash.size();
    }
}