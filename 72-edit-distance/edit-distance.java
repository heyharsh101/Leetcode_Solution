class Solution {
    int m, n;
    int[][] dp;
    public int minDistance(String word1, String word2) {
        m = word1.length();
        n = word2.length();
        dp = new int[m+1][n+1];
        
        for(int i=0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }

        return recursion(0, 0, word1, word2);

    }
    public int recursion(int i, int j, String word1, String word2){
        if(i == m){
            return n - j;
        }
        if(j == n){
            return m - i;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(word1.charAt(i) == word2.charAt(j)){
            return recursion(i+1, j+1, word1, word2);
        } else {
            int insert = 1 + recursion(i+1, j, word1, word2);
            int delete = 1 + recursion(i, j+1, word1, word2);
            int replace = 1 + recursion(i+1, j+1, word1, word2);

            dp[i][j] = Math.min(insert, Math.min(delete, replace));
        }
        return dp[i][j];
    }
}