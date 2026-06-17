class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int INF = (int)1e9;

        int[] dp = new int[n];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n - 1];
    }
}