class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n <= 1) return 0;

        int jump = 0;
        int curr = 0;
        int max = 0;

        for(int i=0; i<n-1; i++){
            max = Math.max(max, i + nums[i]);

            if(i == curr){
                jump++;
                curr = max;

                if(curr >= n-1) break;
            }

        }
        return jump;
    }
}