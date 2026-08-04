class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        for(int i : nums){
            if(i < min){
                min = i;
            }else {
                max = i;
            }
        }

        int j=0;
        for(int i=min; i<max; i++){
            if(nums[j] != i){
                result.add(i);
            } else {
                j++;
            }
            
        }
        return result;
    }
}