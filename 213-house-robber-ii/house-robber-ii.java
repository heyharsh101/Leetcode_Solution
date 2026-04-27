class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);
        
        int case1 = Memorization(nums, 0, n-2, dp);
        int case2 = Memorization(nums, 1, n-1, dp2);

        return Math.max(case1, case2);

    }
    public int Memorization(int[] nums, int st, int end, int[] dp){
        if(st > end) return 0;
        if(dp[st] != -1) return dp[st];

        int pick = nums[st] + Memorization(nums, st+2, end, dp);
        int notpick = Memorization(nums, st+1, end, dp);

        return dp[st] = Math.max(pick, notpick);
    }
}