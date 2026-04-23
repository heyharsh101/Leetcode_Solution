class Solution {
    int n;
    int[][] dp;
    public int coinChange(int[] coins, int amount) {
        n = coins.length;
        dp = new int[amount+1][n];
        for(int i=0 ;i<=amount; i++){
            Arrays.fill(dp[i],-1);
        }
        int ans = Memorization(coins, amount, 0);
        return ans == Integer.MAX_VALUE ? -1:ans;
    }

    public int Memorization(int[] coins, int amount, int i){
        if(amount == 0) return 0;
        if(i >= n) return Integer.MAX_VALUE;
        if(amount < 0) return Integer.MAX_VALUE;
        
        if(dp[amount][i]!= -1) return dp[amount][i];

        int pick = Memorization(coins, amount-coins[i], i);
        if(pick != Integer.MAX_VALUE) pick+=1;
        int notpick = Memorization(coins, amount, i+1);

        return dp[amount][i] = Math.min(pick, notpick); 
    }
}