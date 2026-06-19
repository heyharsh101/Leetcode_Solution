class Solution {
    public int largestAltitude(int[] gain) {
        int ans = 0;
        int acc = 0;

        for(int i=0; i<gain.length; i++){
            acc += gain[i];
            int d = acc - ans;
            ans += d & ~(d >> 31);

        }
        return ans;
    }
}
