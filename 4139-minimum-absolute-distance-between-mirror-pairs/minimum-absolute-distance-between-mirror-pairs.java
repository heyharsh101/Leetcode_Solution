class Solution {
    private int reverse(int x) {
        int rev = 0;
        while (x >0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return rev;
    }

    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        int n = nums.length;
        int ans = (int) 1e6;

        for (int i = 0; i<n; i++) {
            if (mpp.containsKey(nums[i])) {
                ans = Math.min(ans, i-mpp.get(nums[i]));
            }
            mpp.put(reverse(nums[i]), i);
        }
        if(ans == (int)1e6){
            return -1;
        } else {
            return ans;
        }
        
    }
}