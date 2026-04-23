class Solution {
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n][n+1];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(n, nums, 0, -1);
    }

    public int solve(int n , int[] nums, int i, int prev){
        if(i == n){
            return 0;
        }
        if(dp[i][prev+1] != -1){
            return dp[i][prev+1];
        }

        int nottake = solve(n, nums, i+1,   prev);
        int take = 0;
        if(prev == -1 || nums[i] > nums[prev]){
            take = 1 + solve(n, nums, i+1, i);
        }
        return dp[i][prev+1] = Math.max(nottake, take);

    }
}