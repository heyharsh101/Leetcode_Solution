class Solution {
    Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new Boolean[s.length()];
        return canBreak(s, wordDict, 0);
    }

    private boolean canBreak(String s, List<String> wordDict, int index) {
        if (index==s.length()) {
            return true;
        }

        if (dp[index]!=null) {
            return dp[index];
        }

        for (String word : wordDict) {
            int len = word.length();

            if (index+len <= s.length() &&
                s.substring(index, index + len).equals(word)) {

                if (canBreak(s, wordDict, index+len)) {
                    dp[index] = true;
                    return true;
                }
            }
        }

        dp[index] = false;
        return false;
    }
}