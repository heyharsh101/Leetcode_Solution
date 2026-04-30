class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i=0; i<n; i++){
            sum = sum +nums[i];
        }
        if(sum % 2 != 0) return false;

        sum = sum / 2;

        Boolean[][] dp = new Boolean[n][sum+1];
        
        return Memorization(0, sum, nums, dp);

    }
    boolean Memorization(int i, int sum, int[] nums, 
    Boolean[][] dp){
        if(sum == 0) return true;
        if(i >= nums.length) return false;

        if(dp[i][sum] != null) return dp[i][sum];

        boolean take = false;
        if(nums[i] <= sum){
            take = Memorization(i+1, sum - nums[i], nums, dp);
        }
        boolean nottake = Memorization(i+1, sum, nums, dp);

        return dp[i][sum] = take || nottake;
    }
}