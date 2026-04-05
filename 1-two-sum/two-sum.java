class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int sum = 0;

        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                sum = nums[i]+nums[j];
                if(sum == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }
}