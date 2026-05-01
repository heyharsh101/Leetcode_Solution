class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        
        long sum = 0;
        long f0 = 0;
        for(int i=0; i<n ;i++){
            sum = sum + nums[i];
            f0 += (long) i * nums[i];
        }

        long[] dp = new long[n];
        dp[0] = f0;

        long max = dp[0];

        for(int k = 1; k<n; k++){
            dp[k] = dp[k - 1] + sum - (long) n* nums[n - k];
            max = Math.max(max, dp[k]);
        }
        return (int) max;
    }
}