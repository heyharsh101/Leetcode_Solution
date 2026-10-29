class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        return solve(0, s, dp);
    }

    public int solve(int i, String s, int[] dp){
        if(i == s.length()){
            return 1;
        }

        if(s.charAt(i) == '0'){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        int one = solve(i+1, s, dp);

        if(i+1 < s.length()){

            int two = (s.charAt(i) - '0' )*10 + (s.charAt(i+1) - '0');

            if(two >= 10 && two<=26){
                one += solve(i+2, s, dp);
            }
        }

        return dp[i] = one;
    }
}