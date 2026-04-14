import java.util.*;

class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        // Sort robots
        Collections.sort(robot);
        
        // Sort factories by position
        Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Expand factory slots based on limits
        List<Integer> slots = new ArrayList<>();
        for (int[] f : factory) {
            for (int k = 0; k < f[1]; k++) {
                slots.add(f[0]);
            }
        }
        
        int n = robot.size();
        int m = slots.size();
        
        // DP table
        long[][] dp = new long[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE / 2);
        }
        dp[0][0] = 0;
        
        // Fill DP
        for (int j = 1; j <= m; j++) {
            dp[0][j] = 0; // no robots, cost = 0
            for (int i = 1; i <= n; i++) {
                // Option 1: skip this factory slot
                dp[i][j] = Math.min(dp[i][j], dp[i][j-1]);
                // Option 2: assign robot i to this slot
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1] + Math.abs(robot.get(i-1) - slots.get(j-1)));
            }
        }
        
        return dp[n][m];
    }
}
