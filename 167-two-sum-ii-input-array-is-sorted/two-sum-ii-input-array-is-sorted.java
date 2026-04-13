class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length -1;
        int l = 0;
        int r = n;
        while(l < r){
            int sum = nums[l] + nums[r];

            if(sum == target){
                return new int[]{l+1, r+1};
            } else if ( sum < target){
                l++;
            } else {
                r--;
            }

        }
        return new int[]{-1, -1};
    }
}