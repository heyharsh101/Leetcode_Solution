class Solution {
    public void rev(int start, int end, int[] nums){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start = start+1;
            end = end-1;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(k%n ==0){
            return;
        }
        k = k%n;
        rev(0, nums.length-1, nums);
        rev(0, k-1, nums);
        rev(k, nums.length-1, nums);

    }
}