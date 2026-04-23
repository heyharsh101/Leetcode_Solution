class Solution {
    int n;
    int[][] dp;
    public int change(int amount, int[] coins) {
        n = coins.length;
        dp = new int[amount+1][n];
        for(int i=0; i<=amount; i++){
            Arrays.fill(dp[i], -1);
        }
        int ans = Memorization(coins, amount, 0);
        return ans;
    }
    public int Memorization(int[] coins, int amount, int i){
        if(amount == 0) return 1;
        if(i>= n) return 0;
        if(amount < 0) return 0;
        if(dp[amount][i] != -1) return dp[amount][i];

        int pick = Memorization(coins , amount-coins[i], i);

        int notpick = Memorization(coins, amount, i+1);
        dp[amount][i] = pick + notpick;

        return dp[amount][i];
    }
}