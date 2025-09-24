class Solution {
    public int minDistance(String string1, String string2) {
        int N = string1.length();
        int M = string2.length();
        int dp[][] = new int[N + 1][M + 1];

        for(int index1 = 0; index1 <= N; index1++){
            dp[index1][0] = index1;
        }

        for(int index2 = 0; index2 <= M; index2++){
            dp[0][index2] = index2;
        }

        for(int index1 = 1; index1 <= N; index1++){
            for(int index2 = 1; index2 <= M; index2++){
                if(string1.charAt(index1 - 1) == string2.charAt(index2 - 1)){
                    dp[index1][index2] = dp[index1 - 1][index2 - 1];
                }else{
                    dp[index1][index2] = 1 + Math.min(dp[index1 - 1][index2], Math.min(dp[index1][index2 - 1], dp[index1 - 1][index2 - 1]));
                }
            }
        }
        return dp[N][M];
    }
}