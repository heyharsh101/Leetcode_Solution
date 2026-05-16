class Solution {
    public int findMin(int[] nums) {
        int ans=Integer.MAX_VALUE;
       for(int val:nums){
           if(val<ans)ans=val;
       }
       return ans;
    }
}