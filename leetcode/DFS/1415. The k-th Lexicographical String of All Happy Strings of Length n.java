//what is lexographic order ? 

class Solution {
    ArrayList<String> arr ;

    private void dfs(int N, int K, char prevChar, String combination){
        if(arr.size() >= K){
            return;
        }
        if(combination.length() >= N){
            arr.add(combination);
            return;
        }

        switch(prevChar){
            case '#':
                dfs(N, K, 'a', combination + 'a');
                dfs(N, K, 'b', combination + 'b');
                dfs(N, K, 'c', combination + 'c');
                break;
            case 'a':
                dfs(N, K, 'b', combination + 'b');
                dfs(N, K, 'c', combination + 'c');
                break;
            case 'b':
                dfs(N, K, 'a', combination + 'a');
                dfs(N, K, 'c', combination + 'c');
                break;
            default :
                dfs(N, K, 'a', combination + 'a');
                dfs(N, K, 'b', combination + 'b');
                break;
                
        }
    }
    public String getHappyString(int N, int K) {
        arr = new ArrayList<>();
        dfs(N, K, '#', "");
        return ((arr.size() >= K) ? (arr.get((K - 1))) : (""));
    }
}