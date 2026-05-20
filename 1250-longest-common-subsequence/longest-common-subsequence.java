class Solution {
    int[][] dp;
    int n, m;
    public int longestCommonSubsequence(String text1, String text2) {
        n = text1.length();
        m = text2.length();
        dp = new int[n+1][m+1];
        for(int i=0; i<=n; i++){
            Arrays.fill(dp[i], -1);
        }
        return Memorization(text1, text2, 0, 0);
    }
    int Memorization(String t1, String t2, int i, int j){
        if(i==n || j==m) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(t1.charAt(i) == t2.charAt(j)){
            dp[i][j] = 1+Memorization(t1, t2, i+1, j+1);
        } else {
            dp[i][j] = Math.max(Memorization(t1, t2, i+1, j), Memorization(t1, t2, i, j+1));
        }
        return dp[i][j];
    }
}