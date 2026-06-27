class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int maxProd = nums[0];
        int minProd = nums[0];
        int result = nums[0];
        
        for (int i=1; i<n; i++) {
            int curr = nums[i];
            if (curr <0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }
            maxProd = Math.max(curr, maxProd*curr);
            minProd = Math.min(curr, minProd*curr);
            result = Math.max(result, maxProd);
        }
        return result;
    }
}
